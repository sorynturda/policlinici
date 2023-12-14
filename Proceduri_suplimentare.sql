DELIMITER //
CREATE PROCEDURE CautaCont(IN numeUtilizator VARCHAR(30), IN parola VARCHAR(30))
BEGIN
    select * from conturi where conturi.nume_utilizator = numeUtilizator and conturi.parola = parola;
END //
DELIMITER ;