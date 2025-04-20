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

