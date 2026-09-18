CREATE DATABASE IF NOT EXISTS shop;
USE shop;

DROP TABLE IF EXISTS employee;

CREATE TABLE employee(
    employeeId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    password VARCHAR(100)
);
INSERT INTO employee (employeeId,name,password)
VALUES
(1,'Jeff','a'),
(2,'Maximov','b'),
(3,'Vladimir','c');