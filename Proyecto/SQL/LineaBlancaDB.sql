CREATE DATABASE LineaBlanca;
USE LineaBlanca;

CREATE TABLE `usuario_tb`(
  `id_usuario` varchar(10) NOT NULL,
  `nombre_usu` varchar(50) NOT NULL,
  `apellido_usu` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `contrasenia` varchar(50) NOT NULL,
  `acceso` varchar(50) NOT NULL,
  PRIMARY KEY (`id_usuario`)
  );

  
CREATE TABLE `producto_tb`(
  `id_producto`int NOT NULL AUTO_INCREMENT,
  `nombrep` varchar(50) NOT NULL,
  `descrp` varchar(250) NOT NULL,
  `precio` int NOT NULL,
  PRIMARY KEY (`id_producto`)
  );
  

  CREATE TABLE `local_tb`(
  `id_local` varchar(10) NOT NULL,
  `nombre_local` varchar(50) NOT NULL,
  `direccion_local` varchar(50) DEFAULT NULL,
  `estado_wifi` varchar(50) DEFAULT NULL,
  `tipo` int NOT NULL,
  PRIMARY KEY (`id_local`)
  );  
  
CREATE TABLE `cliente_tb`(
  `id_cliente` varchar(10) NOT NULL,
  `nombrec` varchar(50) NOT NULL,
  `apellidoc` varchar(50) NOT NULL,
  PRIMARY KEY (`id_cliente`)
  );