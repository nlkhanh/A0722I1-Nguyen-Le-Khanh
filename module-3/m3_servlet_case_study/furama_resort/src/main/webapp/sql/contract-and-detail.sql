USE furama_resort_db;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_contract_by_id;
CREATE PROCEDURE get_contract_by_id(IN contract_id INT)
BEGIN
    SELECT *
    FROM contract
    WHERE contract.ct_removed = FALSE
      AND contract.ct_id = contract_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_contract_last;
CREATE PROCEDURE get_contract_last()
BEGIN
    SELECT *
    FROM contract
    WHERE contract.ct_removed = FALSE
    ORDER BY ct_id DESC
    LIMIT 1;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS insert_contract;
CREATE PROCEDURE insert_contract(
    IN start_date DATETIME,
    IN end_date DATETIME,
    IN deposit DOUBLE,
    IN total_money DOUBLE,
    IN employee_id INT,
    IN customer_id INT,
    IN service_id INT
)
BEGIN
    INSERT INTO contract (ct_start_date, ct_end_date, ct_deposit, ct_total_money, e_id, c_id, s_id)
    VALUES (start_date, end_date, deposit, total_money, employee_id, customer_id, service_id);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS insert_contract_detail;
CREATE PROCEDURE insert_contract_detail(
    IN contract_id INT,
    IN attach_service_id INT,
    IN quantity_in INT
)
BEGIN
    INSERT INTO contract_detail(ct_id, as_id, quantity)
    VALUES (contract_id, attach_service_id, quantity_in);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS delete_contract;
CREATE PROCEDURE delete_contract(IN contract_id INT)
BEGIN
    UPDATE contract_detail
    SET contract_detail.ct_detail_removed = TRUE
    WHERE contract_detail.ct_id = contract_id;

    UPDATE contract
    SET contract.ct_removed = TRUE
    WHERE contract.ct_id = contract_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS update_contract;
CREATE PROCEDURE update_contract(
    IN contract_id INT,
    IN start_date DATETIME,
    IN end_date DATETIME,
    IN deposit DOUBLE,
    IN total_money DOUBLE,
    IN employee_id INT,
    IN customer_id INT,
    IN service_id INT
)
BEGIN
    UPDATE contract
    SET ct_start_date  = start_date,
        ct_end_date    = end_date,
        ct_deposit     = deposit,
        ct_total_money = total_money,
        e_id           = employee_id,
        c_id           = customer_id,
        s_id           = service_id
    WHERE ct_id = contract_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS update_contract_detail;
CREATE PROCEDURE update_contract_detail(
    IN contract_id INT,
    IN attach_service_id INT,
    IN quantity_in INT
)
BEGIN
    UPDATE contract_detail
    SET ct_detail_removed  = TRUE
    WHERE ct_id = contract_id;
    CALL insert_contract_detail(contract_id, attach_service_id, quantity_in);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_attach_service;
CREATE PROCEDURE get_all_attach_service()
BEGIN
    SELECT * FROM attach_service ORDER BY as_id;
END $$
DELIMITER ;;

