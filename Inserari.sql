INSERT INTO conturi (nume_utilizator, parola) VALUES
    ('superadmin', 'parola123'),
    ('receptioner', 'receptioner123'),
    ('resurseumane', 'resurse123'),
    ('comert', 'comert123'),
    ('medic', 'medic123');


INSERT INTO utilizatori (id_cont, departament, adresa, cnp, nume, prenume, telefon, email, iban, data_angajarii, rol) VALUES
    (1, 'Administrație', 'Strada Administratiei, nr. 1, Bucuresti', '1234567890123', 'Ion', 'Popescu', '0720123456', 'ion.popescu@email.com', 'RO123456789012345678901234567890', '2022-01-01', 'Superadmin'),
    (2, 'Recepție', 'Strada Receptiei, nr. 2, Bucuresti', '2345678901234', 'Maria', 'Ionescu', '0720345678', 'maria.ionescu@email.com', 'RO234567890123456789012345678901', '2022-02-01', 'Receptioner'),
    (3, 'Resurse Umane', 'Strada Resurselor, nr. 3, Bucuresti', '3456789012345', 'Alex', 'Georgescu', '0720567890', 'alex.georgescu@email.com', 'RO345678901234567890123456789012', '2022-03-01', 'Resurse Umane'),
    (4, 'Comert', 'Strada Comertului, nr. 4, Bucuresti', '4567890123456', 'Elena', 'Dumitrescu', '0720789012', 'elena.dumitrescu@email.com', 'RO456789012345678901234567890123', '2022-04-01', 'Comert'),
    (5, 'Medic', 'Strada Medicilor, nr. 5, Bucuresti', '5678901234567', 'Radu', 'Stoica', '0720901234', 'radu.stoica@email.com', 'RO567890123456789012345678901234', '2022-05-01', 'Medic');
	
INSERT INTO program_functionare (duminica, luni, marti, miercuri, joi, vineri, sambata) VALUES
    ('09:00-17:00', '08:00-18:00', '08:00-18:00', '08:00-18:00', '08:00-18:00', '08:00-16:00', '10:00-14:00'),
    ('10:00-16:00', '09:00-17:00', '09:00-17:00', '09:00-17:00', '09:00-17:00', '09:00-15:00', '11:00-13:00'),
    ('08:00-14:00', '07:00-15:00', '07:00-15:00', '07:00-15:00', '07:00-15:00', '07:00-13:00', '09:00-12:00'),
    ('11:00-18:00', '10:00-19:00', '10:00-19:00', '10:00-19:00', '10:00-19:00', '10:00-17:00', '12:00-16:00'),
    ('12:00-20:00', '11:00-21:00', '11:00-21:00', '11:00-21:00', '11:00-21:00', '11:00-19:00', '13:00-17:00');


INSERT INTO policlinici (id_program_functionare, adresa, denumire) VALUES
    (1, 'Strada Sanatatii, nr. 1, Bucuresti', 'Policlinica Centrala'),
    (2, 'Strada Mediciilor, nr. 2, Bucuresti', 'Policlinica Nord'),
    (3, 'Strada Pacientilor, nr. 3, Bucuresti', 'Policlinica Sud'),
    (1, 'Strada Doctorilor, nr. 4, Bucuresti', 'Policlinica Vest'),
    (2, 'Strada Asistentilor, nr. 5, Bucuresti', 'Policlinica Est');
    
    INSERT INTO angajati (id_utilizator, id_policlinica, functie, salariu_negociat, numar_ore) VALUES
    (1, 6, 'Administrator', 5000.00, 40),
    (2, 6, 'Receptioner', 2500.00, 30),
    (3, 6, 'Consilier Resurse Umane', 3500.00, 35),
    (4, 6, 'Agent Comercial', 3000.00, 37),
    (5, 6, 'Medic Specialist', 7000.00, 45),
    (6,6,'Asistent medical',500.00,50);
    
    INSERT INTO pacienti (nume, prenume) VALUES
    ('Popescu', 'Ana'),
    ('Ionescu', 'Mihai'),
    ('Georgescu', 'Elena'),
    ('Dumitrescu', 'Ionut'),
    ('Stoica', 'Cristina');
    
    INSERT INTO medici (id_angajat, cod_parafa, titlu_stiintific, post_didactic, venit_aditional)
VALUES
    (25, 'MP12345', 'Doctor in Medicina', 'Conferentiar Universitar', 500),
    (25, 'MP67890', 'Medic Primar Cardiologie', 'Asistent Universitar', 0),
    (25, 'MP54321', 'Medic Specialist ORL', 'Lector Universitar', 200),
    (25, 'MP98765', 'Doctor in Stomatologie', 'Profesor Universitar', 0),
    (25, 'MP24680', 'Medic Specialist Neurologie', 'Conferentiar Universitar', 300);
    
    INSERT INTO specialitati (id_medic, nume_specialitate, grad) VALUES
    (16, 'Cardiologie', 'Primar'),
    (17, 'Radiologie', 'Specialist'),
    (18, 'ORL', 'Primar'),
    (19, 'Stomatologie', 'Primar'),
    (20, 'Neurologie', 'Primar');
    
    INSERT INTO servicii (nume_serviciu, pret, durata) VALUES
    ('Consultatie Medic Primar', 150.00, '00:30:00'),
    ('Radiografie', 70.00, '00:15:00'),
    ('Tratament ORL', 100.00, '00:45:00'),
    ('Extractie Dentara', 120.00, '00:20:00'),
    ('Consultatie Neurolog', 180.00, '00:40:00');
    
    INSERT INTO orar_medici (id_medic, orar_specific, zi_saptamana_sau_data, ora_inceput, ora_sfarsit) VALUES
    (16, false, 'Luni', '10:00:00', '18:00:00'),
    (17, false, 'Miercuri', '09:00:00', '17:00:00'),
    (18, false, 'Vineri', '07:30:00', '15:30:00'),
    (19, true, '2023-06-30', '11:00:00', '17:00:00'),
    (20, true, '2023-08-15', '13:00:00', '19:00:00');

INSERT INTO policlinica.angajati
VALUES(1, 5, 1, "medic", 6969.69, 55);
SELECT * FROM policlinica.angajati;