# Playground

This repository is a self attempt to see if I am able to create a microservce architecture and use different programming languages to create small and simple senseless services (for example a service that creates random images or reads stuff from a DB or makes trashy things whatsoever). It's about creating a monitored architecture with Prometheus/Grafana, use Docker with Kubernetes to run the whole thing, use Angular to create a Web entrypoint and learn just new things that can be integrated in no time.

## The first idea is as it follows:
- Create a REST service in Kotlin with Swagger and Spring Boot 2. 
  -> This service is going to make a DSL Speedtest and save the data to a MariaDB.
  -> The service will have a HealthCheck implemented in Spring Boot 2 as actuator
  -> The data can be shown in Angular later.
  -> The service will have two REST calls
      -> /speedTest
          -> Returns the result of the confgured Provider etc as a JSON string
      -> /history with parameters of year
