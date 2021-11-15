# Rv-catalog microservice

## Build the image

```bash
docker build -t rv-catalog .
```

## Create network for all our microservices

```bash
docker network create rso
```

## Run database in network
```bash
docker run -d --name pg-rv-catalog --network="rso" -e POSTGRES_USER=dbuser -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=rvs -p 5433:5432 postgres:13
```

## Run the container in network

```bash
docker run -p 8081:8081 --name rv-catalog --network="rso" -e KUMULUZEE_DATASOURCES0_CONNECTIONURL=jdbc:postgresql://pg-rv-catalog:5432/rvs rv-catalog
```

## Run the container from Docker hub in network

```bash
docker run -p 8081:8081 --name rv-catalog --network="rso" anzeha/rv-catalog:latest
```