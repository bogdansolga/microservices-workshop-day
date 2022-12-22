CREATE USER customer_service_admin WITH PASSWORD 'customer_service_admin';

CREATE DATABASE customer_service;
GRANT ALL PRIVILEGES ON DATABASE customer_service TO customer_service_admin;
