create schema test_db AUTHORIZATION DBA;
set schema test_db;

drop table employee if exists;

create table employee (id identity,						
						firstName varchar not null, 
						lastName varchar not null,
						field varchar not null,
						company_position varchar not null,
						company_role varchar not null,
						primary key (id));