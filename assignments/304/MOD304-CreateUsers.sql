
DROP USER 'teamlead'@'localhost';
FLUSH PRIVILEGES;

CREATE USER 'teamlead'@'localhost' IDENTIFIED BY 'test_password';
GRANT ALL PRIVILEGES ON classicmodels.* TO 'teamlead'@'localhost';


CREATE USER 'dbengineer'@'localhost' IDENTIFIED BY 'test';
GRANT SELECT, INSERT, UPDATE, CREATE, EXECUTE ON classicmodels.* TO 'dbengineer'@'localhost';


CREATE USER 'basicuser'@'localhost' IDENTIFIED BY 'test';
GRANT SELECT ON classicmodels.* TO 'basicuser'@'localhost';

USE classicmodels;
SELECT *
FROM customers;



-- --------------  CREATING TABLES 
CREATE TABLE manufacturers (
    manufacturer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    country VARCHAR(50)
);

CREATE TABLE trucks (
    vin VARCHAR(50) PRIMARY KEY,
    manufacturer_id INT,
    model VARCHAR(100),
    transmission VARCHAR(50),
    wheels INT,
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(manufacturer_id)
);

CREATE TABLE motorcycles (
    vin VARCHAR(50) PRIMARY KEY,
    manufacturer_id INT,
    model VARCHAR(100),
    transmission VARCHAR(50),
    wheels INT,
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(manufacturer_id)
);

select user from mysql.user;