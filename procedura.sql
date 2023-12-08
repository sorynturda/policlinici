use phonebook
DELIMITER //
create procedure procedura(IN FirstNameA varchar(20), IN LastNameA varchar(20))
begin
	insert into phonebook.contacts(FirstnAME, LastName) values (FirstNameA, LastNameA);
end
//

drop procedure procedura;

call procedura("ionel", "marcel");