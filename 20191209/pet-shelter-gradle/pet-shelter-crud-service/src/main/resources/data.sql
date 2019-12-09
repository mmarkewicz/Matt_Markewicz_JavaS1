create schema if not exists pet_shelter;
use pet_shelter;

create table if not exists pet (
	  id int not null auto_increment primary key,
	  type varchar(20) not null,
	  name varchar(20) not null,
	  owner varchar(40) not null
);