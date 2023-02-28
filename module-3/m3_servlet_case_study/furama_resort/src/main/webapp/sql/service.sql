USE furama_resort_db;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_service;
CREATE PROCEDURE get_all_service()
BEGIN
    SELECT *
    FROM service
    WHERE s_removed = FALSE
    ORDER BY s_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_service_pagination;
CREATE PROCEDURE get_all_service_pagination(IN record_offset INT, IN record_limit INT)
BEGIN
    SELECT *
    FROM service
    WHERE s_removed = FALSE
    ORDER BY s_id
    LIMIT record_offset, record_limit;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_search_service;
CREATE PROCEDURE get_search_service(IN name VARCHAR(45))
BEGIN
    SELECT *
    FROM service
    WHERE (s_removed = FALSE)
    AND (s_name like CONCAT('%', name, '%'))
    ORDER BY s_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_search_service_pagination;
CREATE PROCEDURE get_search_service_pagination(IN name VARCHAR(45), IN record_offset INT,
                                                 IN record_limit INT)
BEGIN
    SELECT *
    FROM service
    WHERE (s_removed = FALSE)
      AND (s_name like CONCAT('%', name, '%'))
    ORDER BY s_id
    LIMIT record_offset, record_limit;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS insert_service;
CREATE PROCEDURE insert_service(
    IN name VARCHAR(45),
    IN area INT,
    IN cost DOUBLE,
    IN max_people INT,
    IN standard_room VARCHAR(45),
    IN other_convenience VARCHAR(45),
    IN pool_area DOUBLE,
    IN number_of_floors INT,
    IN free_service VARCHAR(45),
    IN rent_type_id INT,
    IN service_type_id INT
)
BEGIN
    INSERT INTO service (s_name, s_area, s_cost, s_max_people, s_standard_room, s_other_convenience,
                         s_pool_area, s_number_of_floors, s_free_service, r_type_id, s_type_id)
    VALUES (name, area, cost, max_people, standard_room,
            other_convenience, pool_area, number_of_floors, free_service, rent_type_id,
            service_type_id);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS delete_service;
CREATE PROCEDURE delete_service(IN id INT)
BEGIN
    UPDATE service
    SET s_removed = TRUE
    WHERE s_id = id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_service_by_id;
CREATE PROCEDURE get_service_by_id(IN id INT)
BEGIN
    SELECT * FROM service WHERE (s_id = id) AND (s_removed = FALSE);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS update_service;
CREATE PROCEDURE update_service(
    IN id INT,
    IN name VARCHAR(45),
    IN area INT,
    IN cost DOUBLE,
    IN max_people INT,
    IN standard_room VARCHAR(45),
    IN other_convenience VARCHAR(45),
    IN pool_area DOUBLE,
    IN number_of_floors INT,
    IN free_service VARCHAR(45),
    IN rent_type_id INT,
    IN service_type_id INT
)
BEGIN
    UPDATE service
    SET s_name = name,
        s_area = area,
        s_cost = cost,
        s_max_people = max_people,
        s_standard_room = standard_room,
        s_other_convenience = other_convenience,
        s_pool_area = pool_area,
        s_number_of_floors = number_of_floors,
        s_free_service = free_service,
        r_type_id = rent_type_id,
        s_type_id = service_type_id
    WHERE s_id = id;
END $$
DELIMITER ;;