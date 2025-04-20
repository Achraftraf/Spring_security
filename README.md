i used the users.ddl

after creating the tables

we can insert some exanple and we use this https://bcrypt-generator.com/   to generate the passwords encryptions

then we can try this 

-- Insert user
INSERT INTO users (username, password, enabled)
VALUES ('achraf', '{bcrypt}$2a$12$Z0z25D.FQpJHSeH3t.H./uDabOEpK.Tjvta6s6zptZW66lfVbQnOq', true);

-- Insert authority/role
INSERT INTO authorities (username, authority)
VALUES ('achraf', 'admin');


now i will costimize it and i will create the table like that -- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
created_at timestamp(6) NULL,
id uuid NOT NULL,
email varchar(255) NOT NULL,
name varchar(255) NOT NULL,
password varchar(255) NOT NULL,
role varchar(255) NOT NULL,
CONSTRAINT users_email_key UNIQUE (email),
CONSTRAINT users_pkey PRIMARY KEY (id)
);


insert query : 

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO public.users (
created_at,
id,
email,
name,
password,
role
) VALUES (
CURRENT_TIMESTAMP,  -- Automatic timestamp
uuid_generate_v4(), -- Auto-generate UUID
'achraf@nttdata.com',
'achraf',
'{bcrypt}$2a$12$Z0z25D.FQpJHSeH3t.H./uDabOEpK.Tjvta6s6zptZW66lfVbQnOq', -- BCrypt hashed password
'admin'
);