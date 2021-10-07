create table role (
    id serial primary key,
    role text
);

create table users (
    id serial primary key,
    name text,
	role_id int references role(id) 
);

create table state (
	id serial primary key,
	status text
);

create table category (
	id serial primary key,
	category text
);

create table rules (
	id serial primary key,
	ItemAdd boolean,
	FindAllItem boolean,
	ReaplaceId boolean,
	DeleteItem boolean,
	FindById boolean,
	FindByName boolean
);

create table role_rules (
    id serial primary key,
    role text,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table item (
	id serial primary key,
	name text,
	user_id int references users(id),
	state_id int references state(id),
	category_id int references category(id)
);

create table comments (
	id serial primary key,
	comment text,
	item_id int references item(id)
);

create table attachs (
	id serial primary key,
	file text,
	item_id int references item(id)
);