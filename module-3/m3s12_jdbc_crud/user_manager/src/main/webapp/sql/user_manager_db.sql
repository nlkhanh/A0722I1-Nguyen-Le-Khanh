CREATE
    DATABASE user_manager_db;
USE
    user_manager_db;

CREATE TABLE users
(
    id      INT(3)       NOT NULL AUTO_INCREMENT,
    `name`  VARCHAR(120) NOT NULL,
    email   VARCHAR(220) NOT NULL,
    country VARCHAR(120) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users(`name`, email, country)
VALUES ('Nguyễn Văn An', 'annguyen@gmail.com', 'Việt Nam'),
       ('Lê Văn Bình', 'binhlv@gmail.com', 'Việt Nam'),
       ('Hồ Thị Yến', 'thiyen@gmail.com', 'Singapore'),
       ('Võ Công Toản', 'toan0404@gmail.com', 'Việt Nam'),
       ('Nguyễn Bỉnh Phát', 'phatphat@gmail.com', 'Singapore'),
       ('Khúc Nguyễn An Nghi', 'annghi20@gmail.com', 'Việt Nam'),
       ('Nguyễn Hữu Hà', 'nhh0101@gmail.com', 'Việt Nam'),
       ('Nguyễn Hà Đông', 'donghanguyen@gmail.com', 'Thái Lan'),
       ('Tòng Hoang', 'hoangtong@gmail.com', 'Việt Nam'),
       ('Nguyễn Công Đạo', 'nguyencongdao12@gmail.com', 'Việt Nam'),
       ('Nguyễn Thị Hào', 'thihao07@gmail.com', 'Việt Nam'),
       ('Phạm Xuân Diệu', 'xuandieu92@gmail.com', 'Thái Lan'),
       ('Trương Đình Nghệ', 'nghenhan2702@gmail.com', 'Việt Nam'),
       ('Dương Văn Quan', 'duongquan@gmail.com', 'Việt Nam'),
       ('Hoàng Trần Nhi Nhi', 'nhinhi123@gmail.com', 'Thái Lan'),
       ('Tôn Nữ Mộc Châu', 'tonnuchau@gmail.com', 'Việt Nam'),
       ('Nguyễn Mỹ Kim', 'kimcuong84@gmail.com', 'Lào'),
       ('Nguyễn Thị Hào', 'haohao99@gmail.com', 'Việt Nam'),
       ('Trần Đại Danh', 'danhhai99@gmail.com', 'Lào'),
       ('Nguyễn Tâm Đắc', 'dactam@gmail.com', 'Việt Nam');

DELIMITER
$$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    WHERE users.id = user_id;
END $$
DELIMITER ;

DELIMITER
$$
CREATE PROCEDURE insert_user(
    IN user_name VARCHAR(120),
    IN user_email VARCHAR(220),
    IN user_country VARCHAR(120)
)
BEGIN
    INSERT INTO users(`name`, email, country)
    values (user_name, user_email, user_country);
END $$
DELIMITER ;

CREATE TABLE Permission
(
    id     INT(11) PRIMARY KEY,
    `name` VARCHAR(50)
);

CREATE TABLE User_Permission
(
    permission_id INT(3),
    user_id       INT(11),
    FOREIGN KEY (permission_id) REFERENCES Permission (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO Permission(id, name)
VALUES (1, 'add'),
       (2, 'edit'),
       (3, 'delete'),
       (4, 'view');

DELIMITER
$$
CREATE PROCEDURE get_all_users()
BEGIN
    select *
    from users;
END $$
DELIMITER ;;

DELIMITER
$$
CREATE PROCEDURE update_user(
    IN user_id INT(11),
    IN user_name VARCHAR(120),
    IN user_email VARCHAR(220),
    IN user_country VARCHAR(120)
)
BEGIN
    UPDATE users
    SET `name`  = user_name,
        email   = user_email,
        country = user_country
    WHERE id = user_id;
END $$
DELIMITER ;;

DELIMITER
$$
CREATE PROCEDURE delete_user(IN user_id INT(11))
BEGIN
    DELETE
    FROM users
    WHERE id = user_id;
END $$
DELIMITER ;;

DELIMITER
$$
DROP PROCEDURE IF EXISTS get_users_pagination;
CREATE PROCEDURE get_users_pagination(IN record_offset INT, IN record_limit INT)
BEGIN
    SELECT id, `name`, email, country
    FROM users LIMIT record_offset, record_limit;
END $$
DELIMITER ;;

DELIMITER
$$
DROP PROCEDURE IF EXISTS get_users_by_country_pagination;
CREATE PROCEDURE get_users_by_country_pagination(IN user_country VARCHAR(120), IN record_offset INT, IN record_limit INT)
BEGIN
    SELECT id, `name`, email, country
    FROM users
    WHERE country LIKE CONCAT('%', user_country, '%')
    LIMIT record_offset, record_limit;
END $$
DELIMITER ;;

DELIMITER
$$
DROP PROCEDURE IF EXISTS get_users_by_country;
CREATE PROCEDURE get_users_by_country(IN user_country VARCHAR(120))
BEGIN
    SELECT id, `name`, email, country
    FROM users
    WHERE country LIKE CONCAT('%', user_country, '%');
END $$
DELIMITER ;;

DELIMITER
$$
DROP PROCEDURE IF EXISTS get_users_sort_name_pagination;
CREATE PROCEDURE get_users_sort_name_pagination(IN record_offset INT, IN record_limit INT)
BEGIN
    SELECT id, `name`, email, country
    FROM users
    ORDER BY `name`
    LIMIT record_offset, record_limit;
END $$
DELIMITER ;;

DELIMITER
$$
DROP PROCEDURE IF EXISTS get_users_by_country_sort_name_pagination;
CREATE PROCEDURE get_users_by_country_sort_name_pagination(IN user_country VARCHAR(120), IN record_offset INT, IN record_limit INT)
BEGIN
    SELECT id, `name`, email, country
    FROM users
    WHERE country LIKE CONCAT('%', user_country, '%')
    ORDER BY `name`
    LIMIT record_offset, record_limit;
END $$
DELIMITER ;;