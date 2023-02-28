USE furama_resort_db;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_employee;
CREATE PROCEDURE get_all_employee()
BEGIN
    SELECT e.*, p.name, d.name, ed.name
    FROM employee e
             INNER JOIN position p ON e.p_id = p.id
             INNER JOIN division d ON e.d_id = d.id
             INNER JOIN education_degree ed ON e.e_degree_id = ed.id
    WHERE e.e_removed = FALSE
    ORDER BY e.e_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_employee_pagination;
CREATE PROCEDURE get_all_employee_pagination(IN record_offset INT, IN record_limit INT)
BEGIN
    SELECT e.*, p.name, d.name, ed.name
    FROM employee e
             INNER JOIN position p ON e.p_id = p.id
             INNER JOIN division d ON e.d_id = d.id
             INNER JOIN education_degree ed ON e.e_degree_id = ed.id
    WHERE e.e_removed = FALSE
    ORDER BY e.e_id
    LIMIT record_offset, record_limit;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_search_employee;
CREATE PROCEDURE get_search_employee(IN employee_name VARCHAR(45))
BEGIN
    SELECT e.*, p.name, d.name, ed.name
    FROM employee e
             INNER JOIN position p ON e.p_id = p.id
             INNER JOIN division d ON e.d_id = d.id
             INNER JOIN education_degree ed ON e.e_degree_id = ed.id
    WHERE e.e_removed = FALSE
      AND (e.e_name like CONCAT('%', employee_name, '%'))
    ORDER BY e.e_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_search_employee_pagination;
CREATE PROCEDURE get_search_employee_pagination(IN employee_name VARCHAR(45), IN record_offset INT,
                                                 IN record_limit INT)
BEGIN
    SELECT e.*, p.name, d.name, ed.name
    FROM employee e
             INNER JOIN position p ON e.p_id = p.id
             INNER JOIN division d ON e.d_id = d.id
             INNER JOIN education_degree ed ON e.e_degree_id = ed.id
    WHERE e.e_removed = FALSE
      AND (e.e_name like CONCAT('%', employee_name, '%'))
    ORDER BY e.e_id
    LIMIT record_offset, record_limit;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS insert_employee;
CREATE PROCEDURE insert_employee(
    IN employee_name VARCHAR(45),
    IN employee_birthday date,
    IN employee_gender bit(1),
    IN employee_id_card VARCHAR(45),
    IN employee_salary DOUBLE,
    IN employee_phone VARCHAR(45),
    IN employee_email VARCHAR(45),
    IN employee_address VARCHAR(45),
    IN employee_p_id INT,
    IN employee_degree_id INT,
    IN employee_d_id INT,
    IN employee_username VARCHAR(255)
)
BEGIN
    INSERT INTO employee(e_name, e_birthday, e_gender, e_id_card, e_salary, e_phone, e_email, e_address, p_id,
                         e_degree_id, d_id, username)
    VALUES (employee_name, employee_birthday, employee_gender, employee_id_card, employee_salary, employee_phone,
            employee_email,
            employee_address, employee_p_id, employee_degree_id, employee_d_id, employee_username);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS delete_employee;
CREATE PROCEDURE delete_employee(IN employee_id INT)
BEGIN
    UPDATE user_role
    SET user_role.u_role_removed = TRUE
    WHERE user_role.username IN
          (SELECT employee.username
           FROM employee
                    INNER JOIN user ON employee.username = user.username
           WHERE employee.e_id = employee_id);

    UPDATE user
    SET user.user_removed = TRUE
    WHERE user.username IN
          (SELECT employee.username FROM employee WHERE employee.e_id = employee_id);

    UPDATE employee
    SET employee.e_removed = TRUE
    WHERE employee.e_id = employee_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_employee_by_id;
CREATE PROCEDURE get_employee_by_id(IN employee_id INT)
BEGIN
    SELECT employee.*, p.name FROM employee
             INNER JOIN position p ON employee.p_id = p.id
             WHERE (e_id = employee_id) AND (e_removed = FALSE);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS update_employee;
CREATE PROCEDURE update_employee(
    IN employee_id INT,
    IN employee_name VARCHAR(45),
    IN employee_birthday DATE,
    IN employee_gender bit(1),
    IN employee_id_card VARCHAR(45),
    IN employee_salary DOUBLE,
    IN employee_phone VARCHAR(45),
    IN employee_email VARCHAR(45),
    IN employee_address VARCHAR(45),
    IN employee_p_id INT,
    IN employee_degree_id INT,
    IN employee_d_id INT
)
BEGIN
    UPDATE employee
    SET e_name     = employee_name,
        e_birthday = employee_birthday,
        e_gender   = employee_gender,
        e_id_card  = employee_id_card,
        e_salary   = employee_salary,
        e_phone    = employee_phone,
        e_email    = employee_email,
        e_address  = employee_address,
        p_id  = employee_p_id,
        e_degree_id = employee_degree_id,
        d_id = employee_d_id
    WHERE e_id = employee_id;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_user;
CREATE PROCEDURE get_all_user()
BEGIN
    SELECT * FROM user WHERE user_removed = FALSE ORDER BY username;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS insert_user;
CREATE PROCEDURE insert_user(IN username_in VARCHAR(255), IN password_in VARCHAR(255))
BEGIN
    INSERT INTO user(username, password)
    VALUES (username_in, password_in);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS delete_user;
CREATE PROCEDURE delete_user(IN username_in VARCHAR(255))
BEGIN
    UPDATE user_role
    SET u_role_removed = TRUE
    WHERE username = username_in;

    UPDATE user
        SET user_removed = TRUE
    WHERE username = username_in;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS update_user_password;
CREATE PROCEDURE update_user_password(IN username_in VARCHAR(255), IN password_in VARCHAR(255))
BEGIN
    UPDATE user
        SET password = password_in
    WHERE username = username_in AND user_removed = FALSE;
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS insert_user_role;
CREATE PROCEDURE insert_user_role(IN username_in VARCHAR(255), IN role_id INT)
BEGIN
    INSERT INTO user_role(username, r_id)
    VALUES (username_in, role_id);
END $$
DELIMITER ;;

DELIMITER $$
DROP PROCEDURE IF EXISTS update_user_role;
CREATE PROCEDURE update_user_role(IN username_in VARCHAR(255), IN role_id INT)
BEGIN
    UPDATE user_role
        SET r_id = role_id
    WHERE username = username_in;
END $$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS get_all_role;
CREATE PROCEDURE get_all_role()
BEGIN
    SELECT * FROM role ORDER BY id;
END $$
DELIMITER ;;