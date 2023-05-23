DROP DATABASE IF EXISTS autores;
CREATE DATABASE autores CHARACTER SET utf8mb4;
USE autores;

CREATE TABLE autores(
    dni       varchar(50) NOT NULL,
    nombre    varchar(50),
    pais      varchar(50),
    edad      int UNSIGNED
);


INSERT INTO autores VALUES ('23230001A','Juan Gomez JuradoXC60','España',38);
INSERT INTO autores VALUES ('48484400A','Juan Cuello Largo','España',43);
INSERT INTO autores VALUES ('11111111B','Pablo Nerurda','Chile',81);
INSERT INTO autores VALUES ('33445566X','Ediciones B','Andorra',51);
INSERT INTO autores VALUES ('88888888Z','Stephen Kings','U.S.A.',65);



