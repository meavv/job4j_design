insert into role (role) values('Администратор');
insert into role (role) values('Пользователь');
insert into role (role) values('Исполнитель');

insert into users (name, role_id) values('Виталий Админ', '1');
insert into users (name, role_id) values('Петр Пользователь', '2');
insert into users (name, role_id) values('Маша Пользователь', '2');
insert into users (name, role_id) values('Василий Исполнитель', '3');

insert into state (status) values('Выполнено');
insert into state (status) values('В работе');
insert into state (status) values('Закрыто');
insert into state (status) values('Создано');

insert into category (category) values('Оргтехника');
insert into category (category) values('ККМ');
insert into category (category) values('Сетевое оборудование');

insert into rules (ItemAdd, FindAllItem, ReaplaceId, DeleteItem, FindById, FindByName) 
				values(true, true,true,true,true,true); //1
				
insert into rules (ItemAdd, FindAllItem, ReaplaceId, DeleteItem, FindById, FindByName) 
				values(true, false, false, false, true, true); //3
				
insert into rules (ItemAdd, FindAllItem, ReaplaceId, DeleteItem, FindById, FindByName) 
				values(false, false, false, false, true, true); //2
				
insert into role_rules (role, role_id, rules_id) values ('Администратор', '1','1');
insert into role_rules (role, role_id, rules_id) values ('Пользователь', '2','3'); 	
insert into role_rules (role, role_id, rules_id) values ('Исполнитель', '3','2'); 	


select * from role
select * from role_rules
select * from state
select * from rules