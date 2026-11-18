# 🃏 Phrasal Verbs Memory Game (Backend API)

API REST que alimenta un juego web de emparejamiento de cartas para aprender phrasal verbs en inglés (nivel B2) con 4 modos de juego: opuestos, sinónimos, traducción y huecos.

> **Estado:** en desarrollo. Infraestructura lista; modelo de datos en construcción.

## 🛠️ Stack
- Java 21
- Spring Boot 3.x (Web, Data JPA, Validation, Lombok)
- PostgreSQL 16
- Docker y Docker Compose
- Maven

## 📋 Requisitos previos
- JDK 21
- Docker Desktop
- Git
- Un IDE para Java (IntelliJ IDEA, VS Code…)

## ⚙️ Configuración
1. Copia la plantilla de variables de entorno:
   ```bash
   cp .env.example .env
   ```
2. Edita `.env` y rellena tus valores. Descripción de cada variable:

   | Variable | Descripción |
      |---|---|
   | `DB_NAME` | Nombre de la base de datos |
   | `DB_URL` | URL JDBC (`jdbc:postgresql://localhost:<puerto>/<DB_NAME>`) |
   | `DB_USER` | Usuario de PostgreSQL |
   | `DB_PASSWORD` | Contraseña de PostgreSQL |

   El puerto de `DB_URL` debe coincidir con el expuesto en `docker-compose.yml`.

3. <Explica aquí cómo llegan estas variables a Spring en tu IDE y por terminal>

## 🚀 Puesta en marcha
1. Clona el repositorio:
   ```bash
   git clone https://github.com/BryanDZV/phrasal-verbs-backend.git
   cd phrasal-verbs-backend
   ```
2. Levanta PostgreSQL:
   ```bash
   docker compose up -d
   ```
3. Arranca la aplicación:
   ```bash
   <comando con mvnw o mvn>
   ```

## ✅ Cómo comprobar que funciona
En la consola debe aparecer un mensaje similar a `Started PhrasalgameApplication in X seconds` sin errores de conexión.


## Fase de desarrollo
1. Creamos Modelos (entidades JPA) y repositorios (interfaces que extienden `JpaRepository`).
- Se crea el modelo `PhrasalVerb` con sus atributos y relaciones.
## 📝 Notas
- `spring.jpa.hibernate.ddl-auto=update` se usa **solo en desarrollo**. Para producción se plantea usar migraciones versionadas (Flyway o Liquibase).