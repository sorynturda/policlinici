CALL InserarePacient('Ana', 'Popescu');
CALL ProgramarePacient(1, 2, '2023-12-14 14:30:00');
CALL SelectareSpecialitatiMedic(1);
CALL EmitereBonFiscal(1, 2, 50.00);
CALL ExtrageRaport(1);
CALL ActualizareRaport(1, 'Istoric actualizat', 'Simptome actualizate', 'Diagnostic actualizat', 'Recomandari actualizate', TRUE);
CALL ValidareRaport(1);
CALL ExtragePacienti();
CALL ExtrageRapoarte();
CALL ExtrageConcediiReadOnly(1);
CALL VenitTotalPoliclinici();
CALL Cheltuieli();
CALL ProfitLunar(12, 2023);
CALL ProfitMedicLocatieSpecialitate(1);
CALL SalariuAngajat(1);
CALL ExtrageOrarReadOnly(1);
CALL InserarePoliclinica(1, 'Strada Popa 13', 'Policlinica Dr. Smith');
CALL InserareServiciiSpecialitati(1, 1);
CALL InserareServiciiOferiteProgramare(1, 1);
CALL InserareServiciiOferiteRaport(1, 1, 'Investigatii detaliate');
CALL InserareServiciiSpecialitateMedic(1, 1);
CALL ExtrageServicii();
CALL ExtrageOrarMedic(1);
CALL CautaCont("superadmin", "parola123");
CALL CautaAngajatDupaUtilizator(1);
