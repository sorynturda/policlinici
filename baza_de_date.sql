-- "NU AVEM FOREIGN KEY AICI, FACEM LA ALTER TABLE IN ALT FISIER"  Dan asked calmly

CREATE SCHEMA IF NOT EXISTS policlinica;
USE policlinica;

create table if not exists conturi(
	id int auto_increment primary key not null,
	nume_utilizator varchar(20) not null,
    parola varchar(20) not null
);

create table if not exists utilizatori(
	id int auto_increment primary key not null,
    id_cont int not null,
    departament varchar(20) not null,
    adresa varchar(50) not null,
    cnp varchar(13) not null,
    nume varchar(30) not null,
    prenume varchar(30) not null,
    telefon varchar(10) not null,
    email varchar(30) not null,
	iban varchar(34) not null,
    data_angajarii date not null,
    rol varchar(15) not null
);

create table if not exists policlinici(
	id int auto_increment primary key not null,
    id_program_functionare int not null,
    adresa varchar(100) not null,
    denumire varchar(50) not null
);

create table if not exists angajati(
	id int auto_increment primary key not null,
    id_utilizator int not null,
    id_policlinica int not null,
    functie varchar(20) not null,
    salariu_negociat decimal(8, 2) not null,
    numar_ore int not null
);

create table if not exists medici(
	id int auto_increment primary key not null,
    id_angajat int not null,
    cod_parafa varchar(10) not null,
    titlu_stiintific varchar(50),
    post_didactic varchar(50),
    venit_aditional decimal(3, 2) default 0
);

create table if not exists asistenti_medicali(
	id int auto_increment primary key not null,
    id_angajat int not null,
    tip varchar(20) not null,
    grad varchar(20) not null
);

create table if not exists program_functionare(
	id int auto_increment primary key not null,
    duminica varchar(10) not null,
    luni varchar(10) not null,
    marti varchar(10) not null,
    miercuri varchar(10) not null,
    joi varchar(10) not null,
    vineri varchar(10) not null,
    sambata varchar(10) not null
);

create table if not exists pacienti(
	id int auto_increment primary key not null,
    nume varchar(20),
    prenume varchar(20)
);

create table if not exists specialitati(
	id int auto_increment primary key not null,
    id_medic int not null,
    nume_specialitate varchar(20) not null,
    grad varchar(20) not null
);

create table if not exists concedii(
    id int auto_increment primary key not null,
    id_angajat int not null,
    data_inceput date not null,
    data_sfarsit date not null
);

create table if not exists bonuri_fiscale(
    id int auto_increment primary key not null,
    id_raport int not null,
    id_angajat int not null,
    total decimal(10,2) not null
);

create table if not exists rapoarte(
    id int auto_increment primary key not null,
    id_pacient int not null,
    id_medic int not null,
    id_asistent int not null,
    nume_medic_recomandare varchar(20),
    prenume_medic_recomandare varchar(20),
    istoric varchar(100),
    simptome varchar(100),
    diagnostic varchar(100),
    recomandari varchar(1000),
    parafa boolean default false
);

create table if not exists programari(
    id int auto_increment primary key not null,
    id_policlinica int not null,
    id_angajat int not null,
    id_pacient int not null,
    id_medic int not null,
    data_si_ora datetime not null
);

create table if not exists servicii(
    id int auto_increment primary key not null,
    id_specialitate int not null,
    nume_serviciu varchar(50) not null,
    pret decimal(10,2) not null,
    durata time not null
);

create table if not exists orar_medici(
    id_medic int not null,
    orar_specific boolean not null default false,
    zi_saptamana_sau_data varchar(20) not null,
    ora_inceput time not null,
    ora_sfarsit time not null
);

create table if not exists servicii_oferite(
    id_policlinica int not null,
    id_serviciu int not null
);

create table if not exists servicii_specialitati(
    id_specialitate int not null,
    id_serviciu int not null
);

create table if not exists servicii_oferite_programare(
    id_programare int not null,
    id_serviciu int not null
);

create table if not exists servicii_oferite_raport(
    id_raport int not null,
    id_serviciu int not null,
    investigatii varchar(500) not null
);

create table if not exists servicii_specialitate_medic(
    id_serviciu int not null,
    id_specialitate int not null
);