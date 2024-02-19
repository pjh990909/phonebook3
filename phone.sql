create table person(
person_id int auto_increment primary key,
name varchar(30),
hp varchar(20),
company varchar(20)
);


INSERT INTO person
VALUES (null,'박종희', '010-1111-1111', '02-555-5555');

select *
from person;

select person_id,
	   name,
       hp,
       company
from person;