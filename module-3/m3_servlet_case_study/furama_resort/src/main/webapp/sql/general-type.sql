USE furama_resort_db;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_customer_type;
CREATE PROCEDURE get_all_customer_types()
BEGIN
    SELECT * FROM customer_type;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_service_type;
CREATE PROCEDURE get_all_service_types()
BEGIN
    SELECT * FROM service_type;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_rent_type;
CREATE PROCEDURE get_all_rent_types()
BEGIN
    SELECT * FROM rent_type;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_position;
CREATE PROCEDURE get_all_position()
BEGIN
    SELECT * FROM position;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_division;
CREATE PROCEDURE get_all_division()
BEGIN
    SELECT * FROM division;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_education_degree;
CREATE PROCEDURE get_all_education_degree()
BEGIN
    SELECT * FROM education_degree;
END $$
DELIMITER ;;