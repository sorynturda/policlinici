use policlinica
DELIMITER //
CREATE PROCEDURE CautaCont(IN numeUtilizator VARCHAR(30), IN parola VARCHAR(30))
BEGIN
    select * from conturi where conturi.nume_utilizator = numeUtilizator and conturi.parola = parola;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE CautaUtilizatorDupaCont(IN id INT)
BEGIN
    select * from utilizatori where id_cont = id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE CautaAngajatDupaUtilizator(IN id INT)
BEGIN
    select * from angajati where id_utilizator = id;
END //
DELIMITER ;