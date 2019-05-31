# Spring Cloud - Coordinating Services

### Service Discovery
 - Why?
    - Recognize the dynamic environment
    - Live look of healthy services
    - Avoid hardcoded references to service location
    - Centralized registry 
 - Status Quo
    - limited load balancing for middle tier
    - DNS insufficient for microservices
    - Registers can become a single point of failure
 - Spring cloud Eureka
    - Used for middle tier loadbalancing
    - Integrated to many other netflix projects
    - Components of Eureka
        - Eureka-Server
        - Eureka-Client
### Circuit breaker with Hystrix
- Role of CB
   - watch for service fault in real time
   - main intension is to prevent cascading failures
   - Turbine
   - Turbine Stream
### Routing Microservice Traffic