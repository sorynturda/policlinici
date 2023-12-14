DELIMITER //
CREATE PROCEDURE InserarePacient(
    IN numePacient VARCHAR(20),
    IN prenumePacient VARCHAR(20)
)
BEGIN
   
    INSERT INTO pacienti (nume, prenume)
    VALUES (numePacient, prenumePacient);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE ProgramarePacient(
    IN idPacient INT,
    IN idMedic INT,
    IN dataSiOraProgramare DATETIME
)
BEGIN
   
    INSERT INTO programari (id_pacient, id_medic, data_si_ora)
    VALUES (idPacient, idMedic, dataSiOraProgramare);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE SelectareSpecialitatiMedic(
    IN idMedic INT
)
BEGIN
    
    SELECT nume_specialitate, grad
    FROM specialitati
    WHERE id_medic = idMedic;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE EmitereBonFiscal(
    IN idRaport INT,
    IN idAngajat INT,
    IN totalBon DECIMAL(10, 2)
)
BEGIN
    
    INSERT INTO bonuri_fiscale (id_raport, id_angajat, total)
    VALUES (idRaport, idAngajat, totalBon);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE ExtrageRaport(
    IN idRaport INT
)
BEGIN
   
    SELECT * FROM rapoarte
    WHERE id = idRaport;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE ActualizareRaport(
    IN idRaport INT,
    IN istoric VARCHAR(100),
    IN simptome VARCHAR(100),
    IN diagnostic VARCHAR(100),
    IN recomandari VARCHAR(1000),
    IN parafa BOOLEAN
)
BEGIN
   
    UPDATE rapoarte
    SET istoric = istoric, simptome = simptome, diagnostic = diagnostic, recomandari = recomandari, parafa = parafa
    WHERE id = idRaport;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE ValidareRaport(
    IN idRaport INT
)
BEGIN
   
    UPDATE rapoarte
    SET parafa = TRUE
    WHERE id = idRaport;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE ExtragePacienti()
BEGIN
    
    SELECT * FROM pacienti;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE ExtrageRapoarte()
BEGIN
    
    SELECT * FROM rapoarte;
END //
DELIMITER ;
