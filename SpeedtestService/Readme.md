**Installation:**

- Define the datasource for the database in the config:
    - url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/homenetwork

- Pass path to configuration file:
    - Dspring.config.location=file:/pathToConfiguration/homeNetworkService.yml 
    
    
- Information for SSL:
    - Get information and verify keystore:
        - keytool -list -v -storetype pkcs12 -keystore keystore.p12