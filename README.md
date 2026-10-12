# BookMyShow (SQL) — Case Study

A learning project that models the data layer of a movie-ticket booking system (in the style of BookMyShow) using **Spring Boot**, **Spring Data JPA / Hibernate** and **MySQL**.

There is no web layer yet. On startup the application creates the schema from the JPA entities and seeds a small sample data set so you can inspect the tables.

## Tech stack

| Area | Choice |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.1.1 |
| Persistence | Spring Data JPA, Hibernate |
| Database | MySQL (database `bookmyshow`) |
| Build | Maven (wrapper pins Maven 3.9.16) |
| Boilerplate | Lombok (`@Getter` / `@Setter`) |

## Quick start

1. Install **JDK 21** and **MySQL**.
2. Create the database:
   ```sql
   CREATE DATABASE bookmyshow;
   ```
3. Check the credentials in [src/main/resources/application.properties](src/main/resources/application.properties) (default: user `root`, empty password, `localhost:3306`).
4. Run:
   ```powershell
   .\mvnw spring-boot:run
   ```

Hibernate creates or updates the tables (`ddl-auto=update`) and `BookmyshowSqlApplication.run()` inserts the sample data. Running it twice inserts the sample data twice.

Having trouble with JDK versions or certificate errors (`PKIX path building failed`)? See [SETUP.md](SETUP.md).

## What gets seeded

One region (Mumbai) → one theater (Maxus Mall) → one screen (S1) with four seats (two Premium, two Gold) → one movie (*Dhrusham 3*) with three shows tomorrow (morning, afternoon, evening). Each show has four `ShowSeat` rows (all `AVAILABLE`), prices per seat type (Premium 500, Gold 800) and one sample `User`.

## Documentation

| File | Contents |
|---|---|
| [ARCHITECTURE.md](ARCHITECTURE.md) | Layers, startup flow, design decisions |
| [DATA_MODEL.md](DATA_MODEL.md) | Entities, relationships, ER diagram, enums |
| [MANIFEST.md](MANIFEST.md) | Map of every file and package |
| [SETUP.md](SETUP.md) | Environment setup and troubleshooting |

## Status and next steps

- Done: entity model, repositories, seed data.
- Not yet: `Ticket` / `Payment` sample records, services, REST controllers, tests, a night show.
- Known gaps are listed in [ARCHITECTURE.md](ARCHITECTURE.md#known-limitations).
