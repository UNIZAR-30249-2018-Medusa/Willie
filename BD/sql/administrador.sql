-- Table: public.administrador

DROP TABLE public.administrador;

CREATE TABLE public.administrador
(
    id integer NOT NULL,
    usuario text NOT NULL,
    pass text NOT NULL,
    CONSTRAINT administrador_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;
INSERT INTO public.administrador VALUES (0,'','21232f297a57a5a743894a0e4a801fc3');
CREATE SEQUENCE my_seq_gen START 2;
ALTER TABLE public.administrador
    OWNER to postgres;