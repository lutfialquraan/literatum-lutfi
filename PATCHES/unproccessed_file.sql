create table unprocessed_file
(
	file_path varchar not null,
	file_id serial not null,
	status int not null
);

create unique index unprocessed_file_file_id_uindex
	on unprocessed_file (file_id);

alter table unprocessed_file
	add constraint unprocessed_file_pk
		primary key (file_id);

