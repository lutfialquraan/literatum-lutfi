create table user_table
(
	first_name varchar not null,
	last_name varchar not null,
	user_name varchar not null,
	email varchar not null,
	password varchar not null
);

create unique index user_table_email_uindex
	on user_table (email);

create unique index user_table_user_name_uindex
	on user_table (user_name);

alter table user_table
	add constraint user_table_pk
		primary key (email);

