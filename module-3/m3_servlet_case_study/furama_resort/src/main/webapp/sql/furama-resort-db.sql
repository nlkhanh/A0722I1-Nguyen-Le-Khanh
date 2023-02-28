DROP DATABASE IF EXISTS furama_resort_db;
CREATE DATABASE furama_resort_db;
USE furama_resort_db;

DROP TABLE IF EXISTS customer_type;
CREATE TABLE customer_type
(
    id   INT NOT NULL PRIMARY KEY,
    name VARCHAR(45)
);

INSERT INTO customer_type
VALUES (1, 'Member'),
       (2, 'Silver'),
       (3, 'Gold'),
       (4, 'Platinum'),
       (5, 'Diamond');

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
    c_removed  BIT(1) DEFAULT FALSE,
    FOREIGN KEY (c_type_id) REFERENCES customer_type (id)
);

DROP TABLE IF EXISTS position;
CREATE TABLE position
(
    id   INT NOT NULL PRIMARY KEY,
    name VARCHAR(45)
);

INSERT INTO position
VALUES (1, 'Lễ tân'),
       (2, 'Phục vụ'),
       (3, 'Chuyên viên'),
       (4, 'Giám sát'),
       (5, 'Quản lý'),
       (6, 'Giám đốc');

DROP TABLE IF EXISTS education_degree;
CREATE TABLE education_degree
(
    id   INT NOT NULL PRIMARY KEY,
    name VARCHAR(45)
);

INSERT INTO education_degree
VALUES (1, 'Trung cấp'),
       (2, 'Cao đẳng'),
       (3, 'Đại học'),
       (4, 'Sau Đại học');

DROP TABLE IF EXISTS division;
CREATE TABLE division
(
    id   INT NOT NULL PRIMARY KEY,
    name VARCHAR(45)
);

INSERT INTO division
VALUES (1, 'Sale - Marketing'),
       (2, 'Hành chính'),
       (3, 'Phục vụ'),
       (4, 'Quản lý');

DROP TABLE IF EXISTS role;
CREATE TABLE role
(
    id   INT NOT NULL PRIMARY KEY,
    name VARCHAR(45)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    username     VARCHAR(255) NOT NULL PRIMARY KEY,
    password     VARCHAR(255) NOT NULL,
    user_removed BIT(1) DEFAULT FALSE
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role
(
    r_id           INT,
    username       VARCHAR(255),
    u_role_removed BIT(1) DEFAULT FALSE,
    FOREIGN KEY (r_id) REFERENCES role (id),
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
    e_removed   BIT(1) DEFAULT FALSE,
    FOREIGN KEY (p_id) REFERENCES position (id),
    FOREIGN KEY (e_degree_id) REFERENCES education_degree (id),
    FOREIGN KEY (d_id) REFERENCES division (id),
    FOREIGN KEY (username) REFERENCES user (username)
);

DROP TABLE IF EXISTS service_type;
CREATE TABLE service_type
(
    id   INT NOT NULL PRIMARY KEY,
    name VARCHAR(45)
);

INSERT INTO service_type
VALUES (1, 'Room'),
       (2, 'House'),
       (3, 'Villa');

DROP TABLE IF EXISTS rent_type;
CREATE TABLE rent_type
(
    id   INT NOT NULL PRIMARY KEY,
    name VARCHAR(45)
);

INSERT INTO rent_type
VALUES (1, 'Giờ'),
       (2, 'Ngày'),
       (3, 'Tháng'),
       (4, 'Năm');

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
    free_service                  VARCHAR(120),
    r_type_id                     INT,
    s_type_id                     INT,
    s_removed                     BIT(1) DEFAULT FALSE,
    FOREIGN KEY (s_type_id) REFERENCES service_type (id),
    FOREIGN KEY (r_type_id) REFERENCES rent_type (id)
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
    ct_removed     BIT(1) DEFAULT FALSE,
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
    as_unit   VARCHAR(45),
    as_status VARCHAR(45),
    as_remove BIT(1) DEFAULT FALSE
);

INSERT INTO attach_service (as_name, as_cost, as_unit, as_status)
VALUES ('Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
       ('Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
       ('Thuê xe đạp', 20000, 'chiếc', 'tốt'),
       ('Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
       ('Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
       ('Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');

DROP TABLE IF EXISTS contract_detail;
CREATE TABLE contract_detail
(
    ct_detail_id      INT AUTO_INCREMENT PRIMARY KEY,
    ct_id             INT,
    as_id             INT,
    quantity          INT,
    ct_detail_removed BIT(1) DEFAULT FALSE,
    FOREIGN KEY (ct_id) REFERENCES contract (ct_id),
    FOREIGN KEY (as_id) REFERENCES attach_service (as_id)
);