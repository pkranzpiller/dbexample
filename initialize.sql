create table person(id serial primary key, username text, password text, firstname text, lastname text, description text);

insert into person(username, password, firstname, lastname, description) values('Oseros','password', 'Patrick', 'Kranzpiller', 'hes pretty cool');
insert into person(username, password, firstname, lastname, description) values('JSONDerulo', 'password', 'Spencer', 'Werneke', 'trololololol');

select * from person;

drop table person;