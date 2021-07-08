# Kubernetes


## 1. Secrets

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
    
## 1. Config-server