create table message (
	id int AUTO_INCREMENT primary key,
	text varchar(255) not null,
	city varchar(50),
	temperature decimal(5, 2),
	latitude decimal(10, 8),
	longitude decimal(11, 8),
	create_date datetime not null,
	original_message_id int,
	user_id int
);

create table user (
  id int AUTO_INCREMENT primary key,
  name varchar(255) not null
);

alter table message add constraint fk_user foreign key (user_id) references user(id);
alter table message add constraint fk_message foreign key (message) references message(id);


