**Installation:**

The service runs without further config with a H2 in memory database on port 8080. 

Endpoints:
- localhost:8080/homeNetwork/speedtest
  - Triggers a new Speedtest
  - Cache time to live is configurable in the application.yml
    -   cache.jcache.config=classpath:ehcache.xml

- localhost:8080/homeNetwork/speedtest-history
  - Retrieves all speedtest results from the database.
  
For proper usage do the following:

- Define the datasource in the application.yml:
  - MariaDB: (I preferred)
    - spring.jpa.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/homenetwork
    - spring.jpa.datasource.username= drauschke
    - spring.jpa.datasource.password= Fightthepower
  - H2 in memory based:
    - spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    - spring.jpa.datasource.url=jdbc:h2:mem:testdb
    - spring.jpa.datasource.driverClassName: org.h2.Driver
    - spring.jpa.datasource.username= sa
    - spring.jpa.datasource.password= ""
  - H2 file based:
    - spring.jpa.datasource.url: jdbc:h2:file:classpath:h2.db
    - spring.jpa.datasource.driverClassName: org.h2.Driver
    - spring.jpa.datasource.username= Lucky
    - spring.jpa.datasource.password= Lorenzo

- Pass path to configuration file when starting the service:
    - Dspring.config.location=file:/pathToConfiguration/homeNetworkService.yml 
    