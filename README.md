# GraphQL - Server

## Microservices

Nombre | Descripción
------------- | -------------
ms-config  | Configuration server
ms-accounts  | Microservicer accounts
ms-customers  | Microservicer customers
ms-graphql | GraphQL - Apollo Server

## Endpoints
Microservice  | Endpoint
------------- | -------------
Listar cuentas| GET /accounts?type=DNI&number=11111111
Listar transacciones por cuenta| GET accounts/<accountId>/transactions