--------------------------------------------------------
--  DDL for schema students_db
--------------------------------------------------------
DROP SCHEMA IF EXISTS students_db;
CREATE SCHEMA IF NOT EXISTS students_db;

--------------------------------------------------------
--  DDL for Table students_db
--------------------------------------------------------
DROP TABLE IF EXISTS students_db.studentsCity;
CREATE TABLE IF NOT EXISTS students_db.studentsCity
(
    id   INT          NOT NULL PRIMARY KEY,
    city VARCHAR(100) NOT NULL

);
--------------------------------------------------------
DROP TABLE IF EXISTS students_db.students;
CREATE TABLE IF NOT EXISTS students_db.students
(
    id      INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(45)  NOT NULL,
    surname VARCHAR(100) NOT NULL,
    course  INT          NOT NULL,
    city_id INT          NOT NULL,
    FOREIGN KEY (city_id) references students_db.studentsCity (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


--------------------------------------------------------
--  DML for Table students_db
--------------------------------------------------------
INSERT INTO students_db.studentsCity(id, city)
VALUES (1, 'MINSK');
INSERT INTO students_db.studentsCity(id, city)
VALUES (2, 'GOMEL');
INSERT INTO students_db.studentsCity(id, city)
VALUES (3, 'MOGILEV');
INSERT INTO students_db.studentsCity(id, city)
VALUES (4, 'GRODNO');

INSERT INTO students_db.students(name, surname, course, city_id)
VALUES ('Alex', 'Surkov', 1, 1);
INSERT INTO students_db.students(name, surname, course, city_id)
VALUES ('Anna', 'Borodich', 2, 2);
INSERT INTO students_db.students(name, surname, course, city_id)
VALUES ('Sergey', 'Kryvnitskiy', 3, 3);
INSERT INTO students_db.students(name, surname, course, city_id)
VALUES ('Alina', 'Kedich', 4, 4);
--------------------------------------------------------


