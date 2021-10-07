create table shops (
	id serial primary key,
	number int,
	city varchar(100),
	director text
)

insert into shops(number, city, director) values('1','Msk', 'Q w E');
update shops set director = 'R R R'
select*from shops;
delete from shops;

