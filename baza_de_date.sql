CREATE SCHEMA IF NOT EXISTS policlinici;
USE policlinici;

create table if not exists cont(
	id int auto_increment primary key not null,
	nume_utilizator varchar(20),
    parola varchar(20)
);

create table if not exists utilizatori(
	id int auto_increment primary key not null,
    id_cont int not null,
    departament varchar(20),
    adresa varchar(50),
    cnp decimal(13, 0),
    nume varchar(30),
    prenume varchar(30),
    telefon decimal(10, 0),
    email varchar(30),
	iban varchar(34),
    data_angajarii date,
    rod varchar(15)
);

create table if not exists angajati(
	id int auto_increment primary key not null,
    id_utilizator int not null,
    id_policlinica int not null,
    functie varchar(20),
    salariu_negociat decimal(8, 2),
    numar_ore int
);

create table if not exists medici(
	id int auto_increment primary key not null,
    id_angajat int not null,
    cod_parafa decimal(10, 0),
    titlu_stiintific varchar(50),
    postul_didactic varchar(50),
    venit_aditional decimal(3, 2)
);

create table if not exists asistenti_medicali(
	id int auto_increment primary key not null,
    id_angajat int not null,
    tip varchar(10),
    grad varchar(10)
);