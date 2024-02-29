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

select person_id as personId,
	   name,
       hp,
       company
from person
where person_id = 9;

delete from person
where person_id = 18;

update person
set name = '기안' ,
	hp = '01015555',
    company = '05-8848'
where person_id = 19 ;

