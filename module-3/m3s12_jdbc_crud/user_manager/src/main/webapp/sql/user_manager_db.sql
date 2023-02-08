CREATE DATABASE user_manager_db;
USE user_manager_db;
CREATE TABLE users (
	id INT(3) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(120) NOT NULL,
    email VARCHAR(220) NOT NULL,
    country VARCHAR(120) NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO users(`name`, email, country) 
VALUES ('Minh','minh@codegym.vn','Viet Nam'),
		('Kante','kante@che.uk','Kenia');