create table message (
	id int AUTO_INCREMENT primary key,
	create_date datetime not null,
	text varchar(255) not null,
	user_id int
);

create table user (
  id int AUTO_INCREMENT primary key,
  name varchar(255) not null
);

alter table message add constraint fk_user foreign key (user_id) references user(id);


