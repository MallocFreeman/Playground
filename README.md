# Playground

This project is a self attempt to see if I am able to create a microservce architecture and use different programming languages to create small and simple senseless services for educational purpose. Well, not 100 percent. My wife asked me about a weather forecast and I thought that I should automize this by using some weather API.

To be honest, this whole project is about learning.
- I want to use Docker now for a while and my current job does not allow using Docker. I started learning it, couldn't use it. Told myself I will do something and use it in private. Never did it. 

- I wanted to use Prometheus and Grafana in a project in my job, this was not allowes so I have to see for myself how I can use it.

- I wanted to learn Kotlin and use it in a new service at my current job. I was not allowd to do this cause it's new and noone has used it so far. I started looking at Kotlin and told myself that I have to check ths.

- I saw a talk from Chad Fowler, told myself that today is the point that I have to change this.

## The Speedtest idea:
- Create a REST service in Kotlin with Swagger and Spring Boot 2. 
  -> This service is going to make a DSL Speedtest and save the data to a MariaDB.
  -> The service will have a HealthCheck implemented in Spring Boot 2 as actuator.
  -> The data can be shown in my webapp with Angular later. (Maybe a progressive web app ?)
  -> The service will have an externalized configuration in form of a .yaml file somewhere on the harddrive 
  -> The service will have two REST calls
      -> /speedtest
          -> Returns the result of the confgured provider and the DSL product as a JSON string
          -> Only one SpeedTest per day will be stored meaning that the latest data of a successful speedtest will updated in the DB.
      -> /history 
          -> With parameters of the year and or month
          -> Returns a result set as a JSON Array with Objects holding the result of the Speedtest and the ISO-8601 timestamps 
