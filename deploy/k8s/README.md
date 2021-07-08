# Kubernetes


## 1. Settings iniciales
1. Generar certificado
    ```bash
    keytool -genkeypair -alias YOU_CONFIG_SERVER_KEY \
       -keyalg RSA -keysize 4096 -sigalg SHA512withRSA \
       -dname 'CN=Config Server,OU=TCI,O=TCI' \
       -keystore config-server.jks \
       -storepass YOU_KEYSTORE_PASSWORD
    ```
1. Crear un secret para jks
    ```bash
    kubectl create secret generic configserver-key --from-file=./config-server.jks
    kubectl get secret
    kubectl describe secret/configserver-key
    ```
1. Convertir [base64](https://www.base64decode.org/) credenciales
    ```bash
    echo -n 'mzegarra@gmail.com' | base64
    echo -n 'git-credentials' | base64
    echo 'cGFzc3dvcmQ=' | base64 --decode
    ```

## 2. Desplegar ms-configuration

1. Crear secret git credentials
    ```bash
    kubectl apply -f ./01-credentials.yaml
    kubectl apply -f ./02-ms-configuration.yaml
    ```
1. Test ms-configuration
    ```bash
    kubectl get pods
    kubectl get svc
    kubectl port-forward <<PODID>> 9060:8888
    kubectl port-forward service/configserver 8888:8888

    curl http://localhost:8888/ms-accounts/default
    curl http://localhost:8888/encrypt -H 'Content-Type: text/plain' -d 'password'
    curl http://localhost:8888/decrypt -H 'Content-Type: text/plain' -d 'crifrado-paso-previo'
    ```

## 3. Desplegar mongo databases

1. Crear database mongo
    ```bash
    kubectl apply -f ./03-ms-accounts-db.yaml
    kubectl apply -f ./03-ms-customers-db.yaml
    ```
## 4. Desplegar microservices

1. Crear database mongo
    ```bash
    kubectl apply -f ./04-ms-accounts.yaml
    kubectl apply -f ./04-ms-customers.yaml
    ```
1. Test ms-accounts
    ```bash
    kubectl get pods
    kubectl get svc
    kubectl port-forward service/ms-accounts 8080:8080

    curl http://localhost:8080/accounts?type=DNI&number=11111111
    curl http://localhost:8080/accounts/100000002/transactions
    ```

1. Test ms-customers
    ```bash
    kubectl get pods
    kubectl get svc
    kubectl port-forward service/ms-customers 8080:8080

    curl http://localhost:8080/customers
    curl http://localhost:8080/customers/DNI/11111112


    curl -i -X POST -H "Content-Type: application/json" \
        -d '{"firstName": "Luis","lastName": "Suarez","createAt": "2020-10-01T11:57:17.837+00:00","documentType": "DNI","documentNumber": "07822902"}' \
        http://localhost:8080/customers

    ```

## 5. Desplegar GraphQL
1. Crear redis
    ```bash
    kubectl apply -f ./05-graphql-cache.yaml
    ```