CREATE TABLE public.paciente (
	id bigserial NOT NULL,
	nome varchar(255) NULL,
	email varchar(255) NULL,
	cpf varchar(11) NULL,
	telefone varchar(10) NULL,
	bairro varchar(255) NULL,
	cep varchar(255) NULL,
	cidade varchar(255) NULL,
	complemento varchar(255) NULL,
	logradouro varchar(255) NULL,
	numero varchar(255) NULL,
	uf varchar(255) NULL,	
	CONSTRAINT paciente_pkey PRIMARY KEY (id)
);
