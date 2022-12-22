# microservices-workshop-day
Microservices workshop day projects

CREATE USER payment_service_admin WITH PASSWORD 'payment_service_admin';
CREATE USER order_service_admin WITH PASSWORD 'order_service_admin';
CREATE USER customer_service_admin WITH PASSWORD 'customer_service_admin';
CREATE DATABASE payment_service;
CREATE DATABASE order_service;
CREATE DATABASE customer_service;
GRANT ALL PRIVILEGES ON DATABASE payment_service TO payment_service_admin;
GRANT ALL PRIVILEGES ON DATABASE customer_service TO customer_service_admin;
GRANT ALL PRIVILEGES ON DATABASE order_service TO order_service_admin;