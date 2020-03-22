DROP DATABASE IF EXISTS springdb;

CREATE DATABASE springdb;

-- \connect springdb;

DROP TABLE IF EXISTS Toy;

DROP TABLE IF EXISTS Orders;

CREATE TABLE Toy
(
    id SERIAL NOT NULL,
    title varchar(200) NOT NULL,
    genre varchar(5) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Orders(
    id SERIAL NOT NULL,
    order_id INT NOT NULL UNIQUE ,
    toy_type varchar(50) NOT NULL,
    order_date date NOT NULL,
    primary key (id)
);

SELECT * FROM Toy;

SELECT * FROM Orders;

INSERT INTO Toy(title, genre)
VALUES('The Post', 'G');

INSERT INTO Toy(title, genre)
VALUES('Swordfish', 'PG');

INSERT INTO Toy(title, genre)
VALUES('The Net', 'LG');

INSERT INTO Orders(order_id,  toy_type, order_date)
VALUES('9001', 'LG', '2017-12-14');

INSERT INTO Orders(order_id, toy_type, order_date)
VALUES('9002', 'PG', '2001-06-08');

INSERT INTO Orders(order_id, toy_type, order_date)
VALUES('9003', 'G', '1995-07-28');

SELECT * FROM Toy;

SELECT * FROM Orders;

-- \connect springdb;

SELECT * FROM Toy;

SELECT * FROM Orders;