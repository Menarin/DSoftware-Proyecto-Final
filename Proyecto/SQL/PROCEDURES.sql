DELIMITER $$
CREATE PROCEDURE `login`(IN us varchar(50), IN password varchar(50))
BEGIN
	SELECT *
    from usuario_tb
    where username = us and contrasenia = password;
END$$
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE `nuevoCliente` (IN newID varchar(10), IN newNombre varchar(50), IN newApellido varchar(50))
BEGIN
	insert into cliente_tb values (newID, newNombre, newApellido);
END $$
DELIMITER ;


DELIMITER $$

CREATE PROCEDURE `nuevoProducto` (IN newArt varchar(50), IN newModelo varchar(70),IN newDescrip varchar(250), IN newPrecio float, IN newCantidad int)
BEGIN

	insert into producto_tb values (NULL ,newArt,newModelo,newDescrip,newPrecio,newCantidad);

END $$
DELIMITER ;