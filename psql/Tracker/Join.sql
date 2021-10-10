create table departments(
    id serial primary key,
    name varchar(255)
);

create table emploers(
    id serial primary key,
    name varchar(255),
    dep_id int references departments(id)
);

select * from departments
select * from emploers

insert into departments(name) values ('Dep 1');
insert into emploers(name) values ('Dep 2');
insert into departments(name) values ('Dep 3');
insert into departments(name) values ('Dep 4');

insert into emploers(name, dep_id) values ('User 1', 1);
insert into emploers(name, dep_id) values ('User 2', 2);
insert into emploers(name, dep_id) values ('User 3', 3);
insert into emploers(name, dep_id) values ('User 4', 1);
insert into emploers(name, dep_id) values ('User 5', 1);
insert into emploers(name, dep_id) values ('User 6', 2);


select * from emploers e left join departments d on e.dep_id = d.id;
select * from emploers e right join departments d on e.dep_id = d.id;
select * from emploers e full join departments d on e.dep_id = d.id;
select * from emploers e cross join departments d;

select * from departments d left join emploers e on e.dep_id = d.id
where e.id is null;

select * from emploers e right join departments d on e.dep_id = d.id;
select * from departments e left join emploers d on d.dep_id = e.id;

create table teens (
	name text,
	gender text
);

select*from teens
insert into teens(name, gender) values ('Man 1', 'M');
insert into teens(name, gender) values ('Man 2', 'M');
insert into teens(name, gender) values ('Man 3', 'M');
insert into teens(name, gender) values ('Man 4', 'M');

insert into teens(name, gender) values ('Wooman 1', 'W');
insert into teens(name, gender) values ('Wooman 2', 'W');
insert into teens(name, gender) values ('Wooman 3', 'W');
insert into teens(name, gender) values ('Wooman 4', 'W');

select n1.name as a
, n2.name as b from teens n1 cross join teens n2
where (n1.gender != n2.gender) = true and n1.gender = 'M';