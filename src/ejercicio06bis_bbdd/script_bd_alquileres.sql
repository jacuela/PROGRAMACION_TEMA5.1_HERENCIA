DROP DATABASE IF EXISTS alquilervehiculos;
CREATE DATABASE alquilervehiculos CHARACTER SET utf8mb4;
USE alquilervehiculos;



CREATE TABLE vehiculo(
    matricula       varchar(50) NOT NULL,
    marca_modelo    varchar(50),
    km              int UNSIGNED DEFAULT 0,
    alquilado       boolean,
    precioKilometro DECIMAL(10,2),
    precioDia       DECIMAL(10,2),
    tipoVehiculo    varchar(50) NOT NULL,  
    PRIMARY KEY (matricula)

);


CREATE TABLE alquiler(
    id 			int UNSIGNED NOT NULL AUTO_INCREMENT,
    matricula    varchar(50) NOT NULL,
    km_inicio   int UNSIGNED NOT NULL,
    km_fin   int UNSIGNED NOT NULL,
    fecha_inicio date,    
    fecha_fin   date,
    importe DECIMAL(10,2),              
    PRIMARY KEY (id),
    CONSTRAINT matricula_vehiculo FOREIGN KEY(matricula) REFERENCES vehiculo(matricula)

);


INSERT INTO vehiculo VALUES ('1111TTT','Volvo XC60',100,true,null,30,'turismo');
INSERT INTO vehiculo VALUES ('2222TTT','Audi A4',0,false,null,30,'turismo');
INSERT INTO vehiculo VALUES ('3333FFF','Citroen C16',250,false,0.5,null,'furgoneta');

INSERT INTO alquiler VALUES (null,'1111TTT',0,100,'2023-01-01','2023-01-05',120);
INSERT INTO alquiler VALUES (null,'3333FFF',0,250,'2023-01-01','2023-01-02',125);
INSERT INTO alquiler VALUES (null,'1111TTT',100,0,'2023-05-19',null,0);


