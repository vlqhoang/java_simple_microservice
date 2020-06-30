# Java Sample Microservices
This project is to demo a simple micro service architecture

## Techs
This project applies the following:

* **Netflix Zuul API Gateway** (intercepting all incoming requests,
perform logging and distribute requests to services).
* **Feign + Ribbon** client load balancing (automatically balancing requests 
to services).
* **Eureka naming server** (Managing all services info).
* Centralized and distributed tracing server with **Spring could sleuth and Zipkin**.
Configured to **local rabbit-mq server**.
* **Spring cloud config** (Holding configs and distribute them to services).
* **Devtool** live reload.
* Simple service managing mechanism with **Spring Actuator**.
* **Hytrix** fault tolerance. (Tobe implement)

## Usage

#### Ports
| Application | Port |
| ------ | ------ |
| Limit Service | 8080, 8081, ...|
| Spring Cloud Config Server | 8888 |
| Currency Exchange Service | 8000, 8001, 8002, ... |
| Currency Calculation Service | 8100, 8101, 8102, ... |
| Netflix Eureka Naming Server | 8761 |
| Netflix Zuul API Gateway Server | 8765 |
| Zipkin Distributed Tracing Server | 9411 |

#### URLs
| Application | URL |
| ------ | ------ |
| Eureka | http://localhost:8761/|
| Zipkin | http://localhost:9411/zipkin/|
| Spring Cloud Config Server | http://localhost:8888/limits-service/default http://localhost:8888/limits-service/dev|
| Gateway | http://localhost:8765/currency-calculation-service/currency-calculation/from/usd/to/vnd/quantity/1000|

#### Terminal commands
```bash
java -jar ./src/zipkin-server-*exec.jar
rabbitmq-server --RABBIT_URI=amqp://localhost
```

#### Detail document
* Detail document is uploaded to document folder in docx format.

#### Zipkin 
Quick Start Page
* https://zipkin.io/pages/quickstart

Downloading Zipkin Jar
* https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec

License
----
MIT