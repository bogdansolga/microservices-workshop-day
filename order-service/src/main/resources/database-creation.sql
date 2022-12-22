CREATE USER order_service_admin WITH PASSWORD 'order_service_admin';

CREATE DATABASE order_service;
GRANT ALL PRIVILEGES ON DATABASE order_service TO order_service_admin;
