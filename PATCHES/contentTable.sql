create table conetnt_table
(
	doi varchar not null,
	path_for_xml varchar not null,
	path_for_html varchar,
	path_for_pdf varchar
);

create unique index conetnt_table_doi_uindex
	on conetnt_table (doi);

alter table conetnt_table
	add constraint conetnt_table_pk
		primary key (doi);


