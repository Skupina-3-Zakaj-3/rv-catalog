# Rv-catalog microservice

## Prerequisites

```bash
docker run -d --name pg-rv-catalog -e POSTGRES_USER=dbuser -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=users -p 5433:5432 postgres:13
```