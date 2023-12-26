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

DELIMITER //
CREATE PROCEDURE CautaAsistentMedical(IN id INT)
BEGIN
    select * from asistenti_medicali where id_angajat = id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE CautaMedic(IN id INT)
BEGIN
    select * from medici where id_angajat = id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE AfiseazaSpecialitati(IN id INT)
BEGIN
    select * from specialitati where id_medic = id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE PoliclinicaDeCareApartineMedic(IN id INT)
BEGIN
    select id_policlinica from angajati inner join medici where angajati.id = medici.id_angajat and medici.id = id;
END //
DELIMITER ;