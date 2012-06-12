create schema test_db AUTHORIZATION DBA;
set schema test_db;

drop table employee if exists;

create table employee (id identity,						
						firstName varchar not null, 
						lastName varchar not null,
						project varchar not null,
						primary key (id));
						
create table project_mates (employee1 int not null,
						employee2 int not null,
						foreign key (employee1) references employee(id),						
						foreign key (employee2) references employee(id));
