Spring Boot "Microservice" Example Project
This is a sample Java / Maven / Spring Boot (version 1.5.6) application that can be used as a starter for creating a microservice complete with built-in health check, metrics and much more. I hope it helps you.

How to Run
This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the java -jar command.

Clone this repository
Make sure you are using JDK 1.8 and Maven 3.x
You can build the project and run the tests by running mvn clean package.

About services

Merchantmanagment:

Get information about system health, configurations, etc.
http://localhost:8081/env,

http://localhost:8081/health,

http://localhost:8081/info,

http://localhost:8081/metrics

Billermanagment:
Get information about system health, configurations, etc.
http://localhost:8082/env,

http://localhost:8082/health,

http://localhost:8082/info,

http://localhost:8082/metrics

Communication:Sunchronous communication between merchant and Biller services.

Authservice:

Merchantmanagment service exposed with Oauth and SSO,

Billermanagment service exposed with Openid connector(Google)
