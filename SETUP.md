# Setup and Troubleshooting

## Prerequisites

| Tool | Version | Notes |
|---|---|---|
| JDK | 21 | The project compiles with Java 21; an older JDK fails with `release version 21 not supported` |
| MySQL | 8.x recommended | Database named `bookmyshow`, reachable on `localhost:3306` |
| Maven | not required | Use the wrapper (`mvnw`), which downloads Maven 3.9.16 |

## Build and run

```powershell
.\mvnw clean install -DskipTests   # build
.\mvnw spring-boot:run             # run and seed the database
```

Make sure `JAVA_HOME` points to JDK 21 first (`java -version` should print 21).

## Database

```sql
CREATE DATABASE bookmyshow;
```

Connection settings are in `src/main/resources/application.properties`:

| Property | Default |
|---|---|
| `spring.datasource.url` | `jdbc:mysql://localhost:3306/bookmyshow` |
| `spring.datasource.username` | `root` |
| `spring.datasource.password` | empty |
| `spring.jpa.hibernate.ddl-auto` | `update` |

To start from a clean slate, drop and recreate the database. The seed data is inserted again on every start.

## VS Code

`.vscode/` is git-ignored, so each developer sets this up locally. A working `.vscode/settings.json` looks like:

```json
{
    "java.jdt.ls.java.home": "C:\\path\\to\\jdk-21",
    "java.configuration.runtimes": [
        { "name": "JavaSE-21", "path": "C:\\path\\to\\jdk-21", "default": true }
    ],
    "terminal.integrated.env.windows": {
        "JAVA_HOME": "C:\\path\\to\\jdk-21",
        "PATH": "C:\\path\\to\\jdk-21\\bin;${env:PATH}"
    },
    "maven.executable.preferMavenWrapper": true
}
```

## Troubleshooting

### `PKIX path building failed` when Maven downloads dependencies

Java does not trust the certificate presented for repo.maven.apache.org. This usually means a corporate proxy re-signs HTTPS traffic with a CA that Windows trusts but the JDK does not.

Make Java use the Windows certificate store:

```powershell
$env:MAVEN_OPTS="-Djavax.net.ssl.trustStoreType=Windows-ROOT -Djavax.net.ssl.trustStore=NUL"
```

Add the same value to `terminal.integrated.env.windows` in `.vscode/settings.json` to make it permanent for this workspace. Do not put it in a committed file: `Windows-ROOT` only exists on Windows.

### `release version 21 not supported`

Maven is running on an older JDK. Point `JAVA_HOME` and `PATH` at JDK 21 and check with `mvn -v`.

### `Communications link failure` or `Access denied` at startup

MySQL is not running, the database does not exist, or the credentials in `application.properties` are wrong.

### Duplicate rows after restarting

Expected. The seed code runs on every start. Drop the database or clear the tables for a fresh seed.
