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

## 1. Desplegar config server

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

    curl http://localhost:8888/clientes/default
    curl http://localhost:8888/encrypt -H 'Content-Type: text/plain' -d 'password'
    curl http://localhost:8888/decrypt -H 'Content-Type: text/plain' -d 'crifrado-paso-previo'
    ```