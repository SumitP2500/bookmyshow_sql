# Project Manifest

A map of what is in this repository and what each file is for.

| Property | Value |
|---|---|
| Maven coordinates | `com.casestudy.bms:bookmyshow_sql:0.0.1-SNAPSHOT` |
| Main class | `com.casestudy.bms.BookmyshowSqlApplication` |
| Java | 21 |
| Spring Boot | 4.1.1 |
| Packaging | jar |

## Root

| Path | Purpose |
|---|---|
| `pom.xml` | Maven build: dependencies (JPA, MySQL driver, Lombok, devtools, JPA test starter) and the Lombok annotation processor |
| `mvnw`, `mvnw.cmd`, `.mvn/wrapper/` | Maven wrapper, pins Maven 3.9.16 |
| `.gitignore`, `.gitattributes` | Git configuration (`.vscode/` is ignored) |
| `README.md` | Overview and quick start |
| `ARCHITECTURE.md` | Structure, flow, design decisions, limitations |
| `DATA_MODEL.md` | Entities, relationships, enums, ER diagram |
| `MANIFEST.md` | This file |
| `SETUP.md` | Environment setup and troubleshooting |

## Source: `src/main/java/com/casestudy/bms`

| Path | Purpose |
|---|---|
| `BookmyshowSqlApplication.java` | Entry point; `run()` seeds sample data; helper methods build tomorrow's show times |

### `model/` — entities and enums

| File | Kind | Notes |
|---|---|---|
| `BaseModel.java` | mapped superclass | `id`, `createdAt`, `updatedAt` |
| `Region.java`, `Theater.java`, `Screen.java`, `Seat.java`, `SeatType.java` | entity | location and seating hierarchy |
| `Movie.java`, `Show.java` | entity | catalogue and scheduling (`Show` → table `bms_show`) |
| `ShowSeat.java`, `ShowSeatType.java` | entity | per-show seat status and pricing |
| `User.java` | entity | table `bms_user` |
| `Ticket.java`, `Payment.java` | entity | booking and payment (no sample data yet) |
| `Feature.java`, `SeatStatus.java`, `TicketStatus.java`, `PaymentMode.java`, `PaymentStatus.java` | enum | stored as strings |

### `repository/` — Spring Data interfaces

`RegionRepository`, `TheaterRepository`, `ScreenRepository`, `SeatRepository`, `SeatTypeRepository`, `MovieRepository`, `ShowRepository`, `ShowSeatRepository`, `ShowSeatTypeRepository`, `UserRepository`. Each extends `JpaRepository<Entity, Long>` with no custom queries.

There are no repositories yet for `Ticket` and `Payment`.

## Resources and tests

| Path | Purpose |
|---|---|
| `src/main/resources/application.properties` | MySQL connection, `ddl-auto=update`, SQL logging |
| `src/test/java/` | Test sources (empty so far) |

## Local only (not committed)

| Path | Purpose |
|---|---|
| `.vscode/settings.json` | Local JDK 21, Maven wrapper preference and trust-store settings |
| `target/` | Build output |
