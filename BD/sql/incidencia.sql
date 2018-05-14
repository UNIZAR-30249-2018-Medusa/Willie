-- Table: public.incidencia

DROP TABLE public.incidencia;

CREATE TABLE public.incidencia
(
    id uuid NOT NULL,
    descripcion text COLLATE pg_catalog."default",
    nombre_incidencia text COLLATE pg_catalog."default",
    exterior boolean,
    "es_notificacion" boolean,
    "hora_fecha_creada" date,
    idespacio text COLLATE pg_catalog."default",
    latitud double precision,
    longitud double precision,
    planta integer,
    "nombre_trabajador" text COLLATE pg_catalog."default",
    username text COLLATE pg_catalog."default",
    password text COLLATE pg_catalog."default",
    "codigo_cancelacion" double precision,
    "nombre_estado" text COLLATE pg_catalog."default",
    "hora_fecha_completada" date,
    CONSTRAINT incidencia_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.incidencia
    OWNER to postgres;