# Kubernetes


## 1. Secrets
## 1. Config-server
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