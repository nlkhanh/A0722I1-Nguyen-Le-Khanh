USE furama_resort_db;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_customer;
CREATE PROCEDURE get_all_customers()
BEGIN
    SELECT c.*, ct.name
    FROM customer c
             INNER JOIN customer_type ct ON c.c_type_id = ct.id
    WHERE c.c_removed = FALSE
    ORDER BY c.c_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_customer_pagination;
CREATE PROCEDURE get_all_customers_pagination(IN record_offset INT, IN record_limit INT)
BEGIN
    SELECT c.*, ct.name
    FROM customer c
             INNER JOIN customer_type ct ON c.c_type_id = ct.id
    WHERE c.c_removed = FALSE
    ORDER BY c.c_id
    LIMIT record_offset, record_limit;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_search_customer;
CREATE PROCEDURE get_search_customers(IN customer_name VARCHAR(45))
BEGIN
    SELECT c.*, ct.name
    FROM customer c
             INNER JOIN customer_type ct ON c.c_type_id = ct.id
    WHERE (c.c_removed = FALSE) AND (c.c_name like CONCAT('%', customer_name, '%'))
    ORDER BY c.c_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_search_customer_pagination;
CREATE PROCEDURE get_search_customers_pagination(IN customer_name VARCHAR(45), IN record_offset INT,
                                                 IN record_limit INT)
BEGIN
    SELECT c.*, ct.name
    FROM customer c
             INNER JOIN customer_type ct ON c.c_type_id = ct.id
    WHERE (c.c_removed = FALSE) AND (c.c_name like CONCAT('%', customer_name, '%'))
    ORDER BY c.c_id
    LIMIT record_offset, record_limit;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS insert_customer;
CREATE PROCEDURE insert_customer(
    IN customer_name VARCHAR(45),
    IN customer_birthday date,
    IN customer_gender bit(1),
    IN customer_id_card VARCHAR(45),
    IN customer_phone VARCHAR(45),
    IN customer_email VARCHAR(45),
    IN customer_address VARCHAR(45),
    IN customer_type_id INT(45)
)
BEGIN
    INSERT INTO customer(c_name, c_birthday, c_gender, c_id_card, c_phone, c_email, c_address, c_type_id)
    VALUES (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email,
            customer_address, customer_type_id);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS delete_customer;
CREATE PROCEDURE delete_customer(IN customer_id INT)
BEGIN
    UPDATE contract_detail
    SET contract_detail.ct_detail_removed = TRUE
    WHERE contract_detail.ct_id IN (SELECT contract.ct_id FROM contract WHERE (contract.ct_removed = FALSE) AND (contract.c_id = customer_id));

    UPDATE contract
    SET contract.ct_removed = TRUE
    WHERE contract.c_id = customer_id;

    UPDATE customer
    SET customer.c_removed = TRUE
    WHERE c_id = customer_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_customer_by_id;
CREATE PROCEDURE get_customer_by_id(IN customer_id INT)
BEGIN
    SELECT * FROM customer WHERE (c_id = customer_id) AND (c_removed = FALSE);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS update_customer;
CREATE PROCEDURE update_customer(
    IN customer_id INT,
    IN customer_name VARCHAR(45),
    IN customer_birthday date,
    IN customer_gender bit(1),
    IN customer_id_card VARCHAR(45),
    IN customer_phone VARCHAR(45),
    IN customer_email VARCHAR(45),
    IN customer_address VARCHAR(45),
    IN customer_type_id INT(45)
)
BEGIN
    UPDATE customer
    SET c_name = customer_name,
        c_birthday = customer_birthday,
        c_gender = customer_gender,
        c_id_card = customer_id_card,
        c_phone = customer_phone,
        c_email = customer_email,
        c_address = customer_address,
        c_type_id = customer_type_id
    WHERE c_id = customer_id;
END $$
DELIMITER ;;