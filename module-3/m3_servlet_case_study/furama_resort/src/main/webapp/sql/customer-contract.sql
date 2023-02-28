USE furama_resort_db;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_customer_contract;
CREATE PROCEDURE get_customers_contract()
BEGIN
    SELECT contract.*, customer.*, contract_detail.*
    FROM customer
             INNER JOIN contract ON customer.c_id = contract.c_id
             LEFT JOIN contract_detail on contract.ct_id = contract_detail.ct_id
    WHERE customer.c_removed = FALSE
    ORDER BY customer.c_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_customer_contract_pagination;
CREATE PROCEDURE get_customers_contract_pagination(IN offset_in INT, IN limit_in INT)
BEGIN
    SELECT contract.*, customer.*, contract_detail.*
    FROM customer
             INNER JOIN contract ON customer.c_id = contract.c_id
             LEFT JOIN contract_detail on contract.ct_id = contract_detail.ct_id
    WHERE customer.c_removed = FALSE
    ORDER BY customer.c_id
    LIMIT offset_in, limit_in;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_customer_contract_search;
CREATE PROCEDURE get_customers_contract_search(IN customer_name VARCHAR(45))
BEGIN
    SELECT contract.*, customer.*, contract_detail.*
    FROM customer
             INNER JOIN contract ON customer.c_id = contract.c_id
             LEFT JOIN contract_detail on contract.ct_id = contract_detail.ct_id
    WHERE customer.c_removed = FALSE
      AND customer.c_name = customer_name
    ORDER BY customer.c_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_customer_contract_search_pagination;
CREATE PROCEDURE get_customers_contract_search_pagination(IN customer_name VARCHAR(45), IN offset_in INT, IN limit_in INT)
BEGIN
    SELECT contract.*, customer.*, contract_detail.*
    FROM customer
             INNER JOIN contract ON customer.c_id = contract.c_id
             LEFT JOIN contract_detail on contract.ct_id = contract_detail.ct_id
    WHERE customer.c_removed = FALSE
      AND customer.c_name = customer_name
    ORDER BY customer.c_id
    LIMIT offset_in, limit_in;
END $$
DELIMITER ;;

