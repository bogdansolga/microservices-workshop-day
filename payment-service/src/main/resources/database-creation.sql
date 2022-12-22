CREATE USER payment_service_admin WITH PASSWORD 'payment_service_admin';

CREATE DATABASE payment_service;
GRANT ALL PRIVILEGES ON DATABASE payment_service TO payment_service_admin;
