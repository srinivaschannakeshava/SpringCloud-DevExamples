#Spring Cloud: Developing services

### What are Microservices?
- Loosely coupled service achitecture with bounded context.
### Why Microservice?
    - desire for faster change
    - need for greater availability
    - Motivation for fine-grained scaling
    - compatible with a DevOps mindset
### Core characterstics of Microservice.
    - Components exposed to service
    - Tied to specific domain (specific functionality)
    - Loosely coupled
    - Built to tolerate failure
    - Continous delivery via automation
    - Built and run by independent team
### Spring Boot
    - Offers opinionated runtime for Spring
    - Convention ,not configuration
    - Opinions can be overwritable
    - Handles Boilerplate setup
    - Simple dependency management
    - Embeds app server in executable jar
    - Built in endpoints for health matrics
### Simplified Env Management with Centralized configuration
    - 

### Offloading Asynchronous activities with Spring tasks
    - Why ?
        - Reduce dependencies between services
        - Support low latency ,high throughput
        - Facilitate event driven computing
    - status quo's
        - Consuming resources even when services arent doing anything
        - Services baked into monolothic deployments
        - Challenges sacling services on demand
        - Difficulty tracing service calls
    - Serverless computing(Funcition as a service)
    - Spring cloud task
        - shortlived , asynchronous microservice
        - itegration of  Spring batch, Spring stream and spring dataflow
        - What does spring cloud task comprise of?
            - Spring boot app with access to beans
            - Task is stateless
            - Bootstrap logic with runner 
            - can subscribe to life cycle events
        - Invoking task
            - scheduled cron job
            - include as a part of datapipeline-(part of dataflow)
            - subscribe to eventbus
            - directly invoked via customn launcher

### Securing Microservices
    - code grant type
    - password grant type
    - 
### Distributed tracing
    - Cloud sleuth
    - zipkin for visualization