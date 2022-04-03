--------------------------------------------------------
--  DDL for schema students_db
--------------------------------------------------------
DROP SCHEMA IF EXISTS students_db;
CREATE SCHEMA IF NOT EXISTS students_db;

--------------------------------------------------------
--  DDL for Table students_db
--------------------------------------------------------
DROP TABLE IF EXISTS students_db.students;
CREATE TABLE IF NOT EXISTS students_db.students
(
    id      INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(45)  NOT NULL,
    surname VARCHAR(100) NOT NULL,
    course  INT          NOT NULL
);
--------------------------------------------------------
DROP TABLE IF EXISTS students_db.studentsCity;
CREATE TABLE IF NOT EXISTS students_db.studentsCity
(
    idCity INT          NOT NULL UNIQUE,
    city   VARCHAR(100) NOT NULL,
    FOREIGN KEY (idCity) references students_db.students (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);
--------------------------------------------------------
--  DML for Table students_db
--------------------------------------------------------
INSERT INTO students_db.students(name, surname, course)
VALUES ('Alex', 'Surkov', 1);
INSERT INTO students_db.students(name, surname, course)
VALUES ('Anna', 'Borodich', 2);
INSERT INTO students_db.students(name, surname, course)
VALUES ('Sergey', 'Kryvnitskiy', 3);
INSERT INTO students_db.students(name, surname, course)
VALUES ('Alina', 'Kedich', 4);
INSERT INTO students_db.students(name, surname, course)
VALUES ('Petr', 'Medvedzev', 5);
--------------------------------------------------------
INSERT INTO students_db.studentsCity(idCity, city)
VALUES (1, 'MINSK');
INSERT INTO students_db.studentsCity(idCity, city)
VALUES (2, 'GOMEL');
INSERT INTO students_db.studentsCity(idCity, city)
VALUES (3, 'MOGILEV');
INSERT INTO students_db.studentsCity(idCity, city)
VALUES (4, 'GRODNO');

