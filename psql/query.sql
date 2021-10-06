create table shops (
	id serial primary key,
	city varchar(100)
)

create table director (
	id serial primary key,
	name varchar(100),
	shops_id int references shops(id) unique
)

create table employee (
	id serial primary key,
	name varchar(100),
	numberStore int references shops(id)
)

create table product (
	id serial primary key,
	nameProduct varchar(100)
)

create table product_store(
	id serial primary key,
	product_id int references product(id),
	shops_id int references shops(id),
	amount int
)

insert into director(id,name,shops_id) values('1','Василий Петрович','1');

insert into employee(id, name, numberStore) values('4','Маша', '2');

insert into product(id, nameProduct) values('3','Ptpsi');

insert into product_store(id, product_id, shops_id, amount) values('6','2','2','25');

select*from shops;
select*from director;
select*from employee;
select*from product;
select*from product_store;
