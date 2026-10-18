# E-commerce Product Catalog

A full-stack application for browsing and filtering products by category, search term, and price.

**Stack:** React · Spring Boot · PostgreSQL

## Features

- Browse products
- Filter by category
- Search by term
- Filter by price

## Repository layout

The Spring Boot service is at the repository root. The React application is in `ecom_frontend/`.

## Run

The backend uses the Maven wrapper:

```bash
./mvnw spring-boot:run
```

Configure the PostgreSQL connection using the application configuration before starting the service. Start the frontend from `ecom_frontend/` using its package scripts.

This is an earlier full-stack project. My current portfolio emphasis is AI infrastructure and data analytics; see the inference gateway and rate-limiter projects on my profile.
