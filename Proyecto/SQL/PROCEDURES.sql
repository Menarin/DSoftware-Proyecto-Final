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