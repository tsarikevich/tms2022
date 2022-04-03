DROP SCHEMA IF EXISTS SHOP_DB;
CREATE SCHEMA IF NOT EXISTS SHOP_DB;
--------------------------------------------------------
DROP TABLE IF EXISTS shop_db.items;
CREATE TABLE IF NOT EXISTS shop_db.items
(
    id           INT          NOT NULL AUTO_INCREMENT,
    name         VARCHAR(100) NOT NULL,
    description  VARCHAR(200) NOT NULL,
    price        DECIMAL      NOT NULL,
    quantity     INT          NOT NULL,
    availability TINYINT      NOT NULL,
    PRIMARY KEY (id)
);
--------------------------------------------------------
INSERT INTO shop_db.items (name, description, price, quantity, availability)
VALUES ('Laptop HP', '15.6", Intel i5, 8 ГБ DDR4, SSD 512 ГБ', 700, 3, true);
INSERT INTO shop_db.items (name, description, price, quantity, availability)
VALUES ('Laptop ACER', '15.6" AMD 5600H, 8 ГБ DDR4, SSD 512 ГБ', 1000, 2, true);
INSERT INTO shop_db.items (name, description, price, quantity, availability)
VALUES ('Smartphone Samsung', '6.7", RAM 8 ГБ, MEMORY 256 ГБ, 12 Мп, 3300 mAh', 800, 0, false);
INSERT INTO shop_db.items (name, description, price, quantity, availability)
VALUES ('Smartphone Apple', '6.1", RAM 4 ГБ, MEMORY 128 ГБ, 12 Мп', 1200, 1, true);