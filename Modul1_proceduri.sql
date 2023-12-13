DELIMITER //
CREATE PROCEDURE CautaAngajat(IN numeFamilie VARCHAR(30), IN prenume VARCHAR(30), IN functie VARCHAR(20))
BEGIN
    SELECT * FROM angajati a
    INNER JOIN utilizatori u ON a.id_utilizator = u.id
    WHERE u.nume = numeFamilie AND u.prenume = prenume AND a.functie = functie;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE ModificaOrar(IN idMedic INT, IN ziuaSauData VARCHAR(20), IN oraInceput TIME, IN oraSfarsit TIME)
BEGIN
    UPDATE orar_medici
    SET ora_inceput = oraInceput, ora_sfarsit = oraSfarsit
    WHERE id_medic = idMedic AND zi_saptamana_sau_data = ziuaSauData;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE SeteazaConcediu(IN idAngajat INT, IN dataInceput DATE, IN dataSfarsit DATE)
BEGIN
    INSERT INTO concedii (id_angajat, data_inceput, data_sfarsit)
    VALUES (idAngajat, dataInceput, dataSfarsit);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE ExtrageOrarReadOnly(IN idMedic INT)
BEGIN
    SELECT * FROM orar_medici
    WHERE id_medic = idMedic;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE ExtrageConcediiReadOnly(IN idAngajat INT)
BEGIN
    SELECT * FROM concedii
    WHERE id_angajat = idAngajat;
END //
DELIMITER ;

