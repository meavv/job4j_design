create table type (
	id serial primary key,
	name text
);

create table product (
	id serial primary key,
	name text,
	type_id int references type(id),
	expired_date date,
	price int
);

insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');
insert into type (name) values ('МОРОЖЕННОЕ');
insert into type (name) values ('ХЛЕБ');

insert into product (name, type_id, expired_date, price) values ('Сыр голландский','1','26.12.2020', 999);

insert into product (name, type_id, expired_date, price) values ('Сыр молочный','1','26.12.2021', 1999);
insert into product (name, type_id, expired_date, price) values ('Сыр колбасный','1','30.10.2021', 2699);
insert into product (name, type_id, expired_date, price) values ('Молоко 1','2','28.11.2021', 2500);
insert into product (name, type_id, expired_date, price) values ('Молоко 2','2','26.12.2021', 3500);
insert into product (name, type_id, expired_date, price) values ('Мороженное 1','3','24.12.2021', 1200);
insert into product (name, type_id, expired_date, price) values ('Мороженное 2','3','29.12.2021', 3650);
insert into product (name, type_id, expired_date, price) values ('Мороженное 3','3','29.12.2021', 3650);
insert into product (name, type_id, expired_date, price) values ('Мороженное 4','3','29.12.2021', 3650);
insert into product (name, type_id, expired_date, price) values ('Хлеб голландский','4','26.12.2020', 1);

select * from product join type t on t.id = product.type_id
where t.name='СЫР';

select * from product where name like '%Мороженное%';

select * from product where expired_date < CURRENT_DATE;

select name, price from product where price = (select max(price) from product);

select COUNT(t.name), t.name from product join type t on t.id = product.type_id
group by t.name;

select * from product join type t on t.id = product.type_id
where t.name in ('СЫР','МОЛОКО');

select COUNT(t.name), t.name from product join type t on t.id = product.type_id
group by t.name
having COUNT(t.name) < 2;

select product.name, t.name from product join type t on t.id = product.type_id;