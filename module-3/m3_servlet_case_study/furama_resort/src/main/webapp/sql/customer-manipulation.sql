USE furama_resort_db;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_customers;
CREATE PROCEDURE get_all_customers()
BEGIN
    SELECT * FROM customer;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_customers_pagination;
CREATE PROCEDURE get_all_customers_pagination(IN record_offset INT, IN record_limit INT)
BEGIN
    SELECT * FROM customer LIMIT record_offset, record_limit;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_search_customers;
CREATE PROCEDURE get_search_customers(IN customer_name VARCHAR(45))
BEGIN
    SELECT * FROM customer WHERE c_name like CONCAT('%', customer_name, '%');
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_search_customers_pagination;
CREATE PROCEDURE get_search_customers_pagination(IN customer_name VARCHAR(45), IN record_offset INT, IN record_limit INT)
BEGIN
    SELECT * FROM customer WHERE c_name like CONCAT('%', customer_name, '%') LIMIT record_offset, record_limit;
END $$
DELIMITER ;;