create table content_meta
(
	doi varchar not null,
	subject varchar,
	article_title varchar,
	author varchar
);

create unique index content_meta_doi_uindex
	on content_meta (doi);

alter table content_meta
	add constraint content_meta_pk
		primary key (doi);

