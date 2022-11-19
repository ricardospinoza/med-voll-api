-- Drop table

-- DROP TABLE public.medico

CREATE TABLE public.medico (
	id bigserial NOT NULL,
	crm varchar(255) NULL,
	email varchar(255) NULL,
	bairro varchar(255) NULL,
	cep varchar(255) NULL,
	cidade varchar(255) NULL,
	complemento varchar(255) NULL,
	logradouro varchar(255) NULL,
	numero varchar(255) NULL,
	uf varchar(255) NULL,
	especialidade varchar(255) NULL,
	nome varchar(255) NULL,
	CONSTRAINT medico_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;
