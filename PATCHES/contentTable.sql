create table content
(
	pathForXml varchar not null,
	pathForPdf varchar,
	pathForHtml varchar,
	contentId serial
);

create unique index content_contentId_uindex
	on content (contentId);

alter table content
	add constraint content_pk
		primary key (contentId);

