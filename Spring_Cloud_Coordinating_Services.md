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
- Client side software load balacer -Ribbon
   - storage of server addresses - serverlists
   - server freshness check - pings
   - sever selection criteria - rules
- Zuul gateway - Route configuration and proxy
   - Zuul Filters - pre filter, routing filter, post filter, error filter
   - Zuul Stages - 

### Connecting microservice through messaging
- Role of messaging in ms
   - Encourages loose coupling
   - Improve scalability and reliability
   - Introduce new intake and processing patterns
   - interact with legacy system
- Spring Cloud Stream
   - framework for building message-driven ms apps
   - Binders 
      - Connects to physical endpoints 
      - Can connect to multipe broker
      - can use different binders with same code
      - write your own binding class
   - @StreamListner
      - Unique to spring cloud stream
      - Handler for inbound messages
      - automatic content type conversion
      - dispatch to multiple methods based on conditional checks
   - Processors in spring cloud stream
      - read data and publish back on success
   > Note: some key concepts  - consumergroup  - statefull & partition of data
