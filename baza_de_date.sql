-- "NU AVEM FOREIGN KEY AICI, FACEM LA ALTER TABLE IN ALT FISIER"  Dan asked calmly

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

create table if not exists policlinici(
	id int auto_increment primary key not null,
    id_program_functionare int not null,
    adresa varchar(100),
    denumire varchar(50)
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

create table if not exists bon_fiscal(
    id int auto_increment primary key not null,
    id_raport int not null,
    id_angajat int not null,
    total decimal(10,2) not null
);

create table if not exists rapoarte(
    id int auto_increment primary key not null,
    id_rapot int not null,
    id_angajat int not null,
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