create table specifications(
    id serial primary key,
    food text
);

create table animals(
    id serial primary key,
    name varchar(255),
	animal text,
	specifications_id int references specifications(id)
);


insert into specifications (food) values ('Хищник');
insert into specifications (food) values ('Всеядный');
insert into specifications (food) values ('Травоядный');


insert into animals (name, animal, specifications_id) values ('Вася','Кот','1');
insert into animals (name, animal, specifications_id) values ('Петя','Медведь','2');
insert into animals (name, animal, specifications_id) values ('Карина','Корова','3');
insert into animals (name, animal, specifications_id) values ('Гена','Крокодил','1');
insert into animals (name, animal) values ('QWe','EWQ');

select * from animals join specifications on animals.specifications_id = specifications.id;
select name as Имя, animal as Животное, food as Еда from animals inner join specifications p on animals.specifications_id = p.id;
select pp.name, p.food from animals as pp join specifications as p on pp.specifications_id = p.id;