CREATE DATABASE furama_resort_db;
USE furama_resort_db;

DROP TABLE IF EXISTS customer_type;
CREATE TABLE customer_type
(
    c_type_id   INT NOT NULL PRIMARY KEY,
    c_type_name VARCHAR(45)
);

DROP TABLE IF EXISTS customer;
CREATE TABLE customer
(
    c_id       INT AUTO_INCREMENT PRIMARY KEY,
    c_type_id  INT,
    c_name     VARCHAR(45),
    c_birthday DATE,
    c_gender   BIT(1),
    c_id_card  VARCHAR(45),
    c_phone    VARCHAR(45),
    c_email    VARCHAR(45),
    c_address  VARCHAR(45),
    FOREIGN KEY (c_type_id) REFERENCES customer_type (c_type_id)
);

DROP TABLE IF EXISTS position;
CREATE TABLE position
(
    p_id   INT NOT NULL PRIMARY KEY,
    p_name VARCHAR(45)
);

DROP TABLE IF EXISTS education_degree;
CREATE TABLE education_degree
(
    e_degree_id   INT NOT NULL PRIMARY KEY,
    e_degree_name VARCHAR(45)
);

DROP TABLE IF EXISTS division;
CREATE TABLE division
(
    d_id   INT NOT NULL PRIMARY KEY,
    d_name VARCHAR(45)
);

DROP TABLE IF EXISTS role;
CREATE TABLE role
(
    r_id   INT NOT NULL PRIMARY KEY,
    r_name VARCHAR(45)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    username VARCHAR(255) NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role
(
    r_id     INT,
    username VARCHAR(255),
    FOREIGN KEY (r_id) REFERENCES role (r_id),
    FOREIGN KEY (username) REFERENCES user (username)
);

DROP TABLE IF EXISTS employee;
CREATE TABLE employee
(
    e_id        INT AUTO_INCREMENT PRIMARY KEY,
    e_name      VARCHAR(45),
    e_birthday  DATE,
    e_gender    BIT(1),
    e_id_card   VARCHAR(45),
    e_salary    DOUBLE,
    e_phone     VARCHAR(45),
    e_email     VARCHAR(45),
    e_address   VARCHAR(45),
    p_id        INT,
    e_degree_id INT,
    d_id        INT,
    username    VARCHAR(255),
    FOREIGN KEY (p_id) REFERENCES position (p_id),
    FOREIGN KEY (e_degree_id) REFERENCES education_degree (e_degree_id),
    FOREIGN KEY (d_id) REFERENCES division (d_id),
    FOREIGN KEY (username) REFERENCES user (username)
);

DROP TABLE IF EXISTS service_type;
CREATE TABLE service_type
(
    s_type_id   INT NOT NULL PRIMARY KEY,
    s_type_name VARCHAR(45)
);

DROP TABLE IF EXISTS rent_type;
CREATE TABLE rent_type
(
    r_type_id   INT NOT NULL PRIMARY KEY,
    r_type_name VARCHAR(45),
    r_type_cost DOUBLE
);

DROP TABLE IF EXISTS service;
CREATE TABLE service
(
    s_id                          INT AUTO_INCREMENT PRIMARY KEY,
    s_name                        VARCHAR(45),
    s_area                        INT,
    s_cost                        DOUBLE,
    s_max_people                  INT,
    standard_room                 VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area                     DOUBLE,
    number_of_floors              INT,
    r_type_id                     INT,
    s_type_id                     INT,
    FOREIGN KEY (s_type_id) REFERENCES service_type (s_type_id),
    FOREIGN KEY (r_type_id) REFERENCES rent_type (r_type_id)
);

DROP TABLE IF EXISTS contract;
CREATE TABLE contract
(
    ct_id          INT AUTO_INCREMENT PRIMARY KEY,
    ct_start_date  DATETIME,
    ct_end_date    DATETIME,
    ct_deposit     DOUBLE,
    ct_total_money DOUBLE,
    e_id           INT,
    c_id           INT,
    s_id           INT,
    FOREIGN KEY (e_id) REFERENCES employee (e_id),
    FOREIGN KEY (c_id) REFERENCES customer (c_id),
    FOREIGN KEY (s_id) REFERENCES service (s_id)
);

DROP TABLE IF EXISTS attach_service;
CREATE TABLE attach_service
(
    as_id     INT AUTO_INCREMENT PRIMARY KEY,
    as_name   VARCHAR(45),
    as_cost   DOUBLE,
    as_unit   INT,
    as_status VARCHAR(45)
);

DROP TABLE IF EXISTS contract_detail;
CREATE TABLE contract_detail
(
    ct_detail_id     INT AUTO_INCREMENT PRIMARY KEY,
    ct_id   INT,
    as_id   INT,
    quantity INT,
    FOREIGN KEY (ct_id) REFERENCES contract(ct_id),
    FOREIGN KEY (as_id) REFERENCES attach_service(as_id)
);