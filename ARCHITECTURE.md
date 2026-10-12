# Architecture

## Overview

A single Spring Boot application with a persistence-only design: JPA entities, Spring Data repositories, and a `CommandLineRunner` that seeds data at startup.

```
┌─────────────────────────────────────────────┐
│ BookmyshowSqlApplication (CommandLineRunner)│  seeds sample data on startup
└───────────────────┬─────────────────────────┘
                    │ @Autowired
┌───────────────────▼─────────────────────────┐
│ repository/  Spring Data JPA interfaces     │  one per entity, no custom queries yet
└───────────────────┬─────────────────────────┘
                    │ generated proxies (SimpleJpaRepository)
┌───────────────────▼─────────────────────────┐
│ model/  JPA entities (extend BaseModel)     │
└───────────────────┬─────────────────────────┘
                    │ Hibernate
              ┌─────▼─────┐
              │   MySQL   │  database: bookmyshow
              └───────────┘
```

Package root: `com.casestudy.bms`

| Package | Role |
|---|---|
| `com.casestudy.bms` | Application entry point and seed logic |
| `com.casestudy.bms.model` | Entities and enums |
| `com.casestudy.bms.repository` | `JpaRepository` interfaces |

## Domain areas

- **Location hierarchy:** `Region` → `Theater` → `Screen` → `Seat`
- **Catalogue and scheduling:** `Movie` → `Show` (a movie played on a screen at a time)
- **Pricing and availability:** `ShowSeatType` (price per seat type per show) and `ShowSeat` (status of each seat for each show)
- **Booking:** `User`, `Ticket`, `Payment`

See [DATA_MODEL.md](DATA_MODEL.md) for the full relationships.

## Startup flow

1. Spring Boot starts and Hibernate runs `ddl-auto=update`, creating or altering tables from the entities.
2. Spring Data scans `com.casestudy.bms` and registers a proxy bean for every repository interface.
3. `run()` in [BookmyshowSqlApplication.java](src/main/java/com/casestudy/bms/BookmyshowSqlApplication.java) saves the sample data.

## Design decisions

**Common base class.** Every entity extends `BaseModel`, which provides an `int id` (auto-increment), `createdAt` and `updatedAt` (Hibernate timestamps).

**Save parents before children.** Relationships use `@ManyToOne` with no cascade. Hibernate does not persist the other side automatically, so each referenced object must already be saved. The seed code therefore saves in this order: Region, Theater, Screen, SeatType, Seat, Movie, Show, ShowSeat and ShowSeatType, User.

**Inverse sides are read-only.** Lists such as `Region.theaters`, `Screen.seats`, `Movie.shows` and `Ticket.payments` are `@OneToMany(mappedBy = ...)`. The foreign key lives on the child, so setting these lists does not write anything.

**Enums as strings.** Enum columns use `@Enumerated(EnumType.STRING)`. Enum lists (`features` on `Movie`, `Screen`, `Show`) also use `@ElementCollection`, which stores them in separate collection tables.

**Show seats versus seats.** `Seat` is a physical seat on a screen. `ShowSeat` is that seat for one specific show and carries the booking state (`AVAILABLE`, `BOOKED`, `BLOCKED`). This lets one physical seat be booked independently per show.

**Pricing per show and seat type.** `ShowSeatType` stores the price, so the same seat type can cost different amounts in different shows.

**Reserved table names.** `Show` is mapped as `bms_show` and `User` as `bms_user`. `Seat.row` and `Seat.column` map to `bms_row` and `bms_column`. These avoid SQL reserved words.

**Dependency injection.** Repositories are injected into the main class with field `@Autowired`. `@Repository` on the interfaces is optional because Spring Data registers them anyway.

**Time zone.** Show times are built in `Asia/Kolkata` (IST) and stored as `java.util.Date`.

## Known limitations

- Seed data is inserted on every run, so repeated runs create duplicates.
- `ShowSeatType` has no uniqueness constraint on (show, seat type), so duplicates are possible.
- Entity ids are `int` while the repositories are declared as `JpaRepository<T, Long>`.
- `ticket` on `ShowSeat` is unset in the seed data. `Ticket` and `Payment` samples are not created yet.
- No service layer, controllers, validation or tests.
- `User.password` is a plain string. Hashing is needed before any real use.
- Database credentials are in `application.properties` in plain text, with an empty password.
- The evening show ends at the "night" time (21:30), but there is no night show.

## Likely next steps

1. Booking flow: reserve `ShowSeat` rows, create a `Ticket`, record a `Payment`.
2. Service layer with `@Transactional` boundaries.
3. REST controllers.
4. Tests, using the already-included `spring-boot-starter-data-jpa-test`.
5. Move the seed data to a dedicated profile or a SQL migration tool.
