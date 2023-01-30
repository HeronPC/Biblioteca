CREATE DATABASE if NOT EXISTS  BIBLIO;

USE BIBLIO;

CREATE or replace TABLE TABLA_BIBLIO(
ID INT(5) PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(60),
Foto VARCHAR(100),
Genero VARCHAR(20),
Autor VARCHAR(50),
Editorial VARCHAR(50),
ISBN VARCHAR(50) UNIQUE,
Descripcion VARCHAR(200),
stock INT
);

CREATE or replace TABLE usuarios(
DNI CHAR(9) PRIMARY KEY,
Pswd VARCHAR(15),
userroot INT,
Ban DATE,
img VARCHAR(100),
email VARCHAR(100),
telefono CHAR(9),
nombre VARCHAR(50)
);

INSERT INTO usuarios (dni, pswd, userroot) VALUES ('root', 'root', 1);