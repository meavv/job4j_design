create table body(
    id serial primary key,
    name varchar(255)
);

create table engine(
    id serial primary key,
    name varchar(255)
);

create table transmission(
    id serial primary key,
    name varchar(255)
);

create table car(
    id serial primary key,
    name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into body (name) values ('body 1');
insert into body (name) values ('body 2');
insert into body (name) values ('body 3');
insert into body (name) values ('body 4');

insert into engine (name) values ('engine 1');
insert into engine (name) values ('engine 2');
insert into engine (name) values ('engine 3');
insert into engine (name) values ('engine 4');

insert into transmission (name) values ('transmission 1');
insert into transmission (name) values ('transmission 2');
insert into transmission (name) values ('transmission 3');
insert into transmission (name) values ('transmission 4');

insert into car (name, body_id, engine_id, transmission_id) values ('car 1','1','1','1');
insert into car (name, body_id, engine_id, transmission_id) values ('car 2','2','2','2');
insert into car (name, body_id, engine_id, transmission_id) values ('car 221','2','2','1');
insert into car (name, body_id, engine_id, transmission_id) values ('car 332','3','3','2');

select * from car join body on car.body_id = body.id
					join engine on car.engine_id = engine.id
					 join transmission on car.transmission_id = transmission.id
					 
select * from body left join car on  car.body_id = body.id where car.id is null
select * from transmission left join car on  car.transmission_id = transmission.id where car.id is null
select * from engine left join car on  car.engine_id = engine.id where car.id is null
