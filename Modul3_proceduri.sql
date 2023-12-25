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

DELIMITER //
CREATE PROCEDURE AfiseazaMedici()
BEGIN
    
	SELECT m.id, m.id_angajat, m.cod_parafa, m.titlu_stiintific, m.post_didactic, m.venit_aditional, u.nume, u.prenume FROM utilizatori u, medici m
	JOIN angajati a 
	WHERE a.functie = "medic" AND a.id_utilizator = u.id and m.id_angajat = a.id;


END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE OrarAngajat(
	IN id_angajat INT
)
BEGIN
    
	SELECT pf.id, pf.duminica, pf.luni, pf.marti, pf.miercuri, pf.joi, pf.vineri, pf.sambata FROM program_functionare pf
	INNER JOIN angajati a
	INNER JOIN policlinici p
	WHERE a.id = id_angajat AND a.id_policlinica = p.id AND p.id_program_functionare = pf.id;

END //
DELIMITER ;