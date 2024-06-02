-- Restart, clean slate
DROP USER IF EXISTS 'superUser_1';
DROP USER IF EXISTS 'editor_1';
DROP USER IF EXISTS 'viewer_only_1';
DROP TABLE IF EXISTS jobs;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS departments;
DROP DATABASE IF EXISTS homeworkModels;

-- SEE USERS
SELECT user FROM mysql; 

CREATE DATABASE homeworkModels;
-- Step #1.1 Create three users 
-- Step #1.2 Assign privileges for users 
CREATE USER 'superUser_1'@'localhost' IDENTIFIED BY 'test';
CREATE USER 'editor_1'@'localhost' IDENTIFIED BY 'test';
CREATE USER 'viewer_only_1'@'localhost' IDENTIFIED BY 'test';

GRANT ALL PRIVILEGES ON homeworkModels.* TO 'superUser_1'@'localhost';
GRANT SELECT, INSERT, UPDATE, CREATE, EXECUTE ON homeworkModels.* TO 'editor_1'@'localhost';
GRANT SELECT ON homeworkModels.* TO 'viewer_only_1'@'localhost';

-- Step #2 Create three tables, including relationships for each table with user1
USE homeworkModels;

CREATE TABLE Users(
	id int NOT NULL auto_increment UNIQUE,
    firstName varchar(100) NOT NULL,
    lastName varchar(100) NOT NULL,
    supervisor_id int,
    job_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (job_id) REFERENCES Jobs(id)
    ON DELETE SET NULL
);

CREATE TABLE Jobs(
	id int NOT NULL auto_increment UNIQUE,
    role_name varchar(100) NOT NULL,
    salary FLOAT,
    dept_id int NOT NULL,
    user_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (dept_id) REFERENCES Departments(id)
);

CREATE TABLE Departments(
	id int NOT NULL auto_increment UNIQUE,
    dept_title varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

-- Insert Five entities to each row 
