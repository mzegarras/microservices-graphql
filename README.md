# GraphQL - Server

## Microservices

Nombre | Descripción
------------- | -------------
ms-config  | Configuration server
ms-accounts  | Microservicer accounts
ms-customers  | Microservicer customers
ms-graphql | GraphQL - Apollo Server

### Endpoints
Microservice  | Descripción  | Endpoint
------------- | ------------- | -------------
Accounts | Listar cuentas de un cliente| GET /accounts?type=DNI&number=11111111
Accounts | Listar transacciones por cuenta| GET accounts/\<accountId>/transactions
Customers | Listar clientes| GET /customers
Customers | Listar clientes| GET /customers/DNI/11111112

### Data

#### Customers

DocumentType  | DocumentNumber  | LastName | FirstName
------------- | ------------- | -------------| -------------
DNI|11111111|Messi|Lionel
DNI|11111112|Ronaldo|Cristiano
DNI|11111113|Emape|Gillian

#### Accounts

DocumentType  | DocumentNumber  | Número | Moneda
------------- | ------------- | -------------| -------------
DNI|11111111|100000001|1001
DNI|11111111|100000002|1000
DNI|11111112|100000003|1001
DNI|11111113|100000004|1001

