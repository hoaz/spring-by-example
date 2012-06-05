insert into employee (id, first_name, last_name, project) values (1, 'Oleksiy', 'Rezchykov', 'Labs');
insert into employee (id, first_name, last_name, project) values (2, 'Eugene', 'Scripnik', 'Labs');
insert into project_mates (employee1, employee2) values (1, 2);
insert into project_mates (employee1, employee2) values (2, 1);