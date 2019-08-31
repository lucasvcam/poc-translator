CREATE TABLE IF NOT EXISTS translators
(
    id serial NOT NULL,
    name character varying(40) NOT NULL,
    email character varying(60) NOT NULL,
    source_language character varying(5) NOT NULL,
    target_language character varying(5) NOT NULL,
    PRIMARY KEY (id)
);

CREATE INDEX  IF NOT EXISTS idx_translator ON translators 
(id, name, email, source_language, target_language);


CREATE TABLE IF NOT EXISTS languages
(
    id serial NOT NULL,
    description character varying(5) NOT NULL,
    CONSTRAINT languages_pkey PRIMARY KEY (id)
);

CREATE INDEX  IF NOT EXISTS idx_language ON languages 
(id, description);