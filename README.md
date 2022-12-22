# microservices-workshop-day
Microservices workshop day projects

### Databases and users creation
```
CREATE USER order_service_admin WITH PASSWORD 'order_service_admin';
CREATE DATABASE order_service;
GRANT ALL PRIVILEGES ON DATABASE order_service TO order_service_admin;
\c order_service
GRANT ALL ON SCHEMA public TO order_service_admin;

CREATE USER customer_service_admin WITH PASSWORD 'customer_service_admin';
CREATE DATABASE customer_service;
GRANT ALL PRIVILEGES ON DATABASE customer_service TO customer_service_admin;
\c customer_service
GRANT ALL ON SCHEMA public TO customer_service_admin;

CREATE USER payment_service_admin WITH PASSWORD 'payment_service_admin';
CREATE DATABASE payment_service;
GRANT ALL PRIVILEGES ON DATABASE payment_service TO payment_service_admin;
\c payment_service
GRANT ALL ON SCHEMA public TO payment_service_admin;
```

### Starting Kafka
```
* Mac & Linux:
    ./bin/zookeeper-server-start.sh config/zookeeper.properties
    ./bin/kafka-server-start.sh config/server.properties

* Win: 
    .\bin\windows\zookeeper-server-start.bat config\zookeeper.properties
    .\bin\windows\kafka-server-start.bat config\zookeeper.properties
```

### Kafka topics creation
```
* Mac & Linux:
    ./bin/kafka-topics.sh --create --topic request_credit           --bootstrap-server localhost:9092
    ./bin/kafka-topics.sh --create --topic request_credit_response  --bootstrap-server localhost:9092
    ./bin/kafka-topics.sh --create --topic request_payment          --bootstrap-server localhost:9092
    ./bin/kafka-topics.sh --create --topic request_payment_response --bootstrap-server localhost:9092

* Windows:
    .\bin\windows\kafka-topics.bat --create --topic request_credit           --bootstrap-server localhost:9092
    .\bin\windows\kafka-topics.bat --create --topic request_credit_response  --bootstrap-server localhost:9092
    .\bin\windows\kafka-topics.bat --create --topic request_payment          --bootstrap-server localhost:9092
    .\bin\windows\kafka-topics.bat --create --topic request_payment_response --bootstrap-server localhost:9092
```