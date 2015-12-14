# Users schema

# --- !Ups

CREATE SCHEMA users;
CREATE TABLE users.users (
  id serial PRIMARY KEY,
  email character varying(255) UNIQUE,
  name character varying(255) UNIQUE,
  password character varying(255)
);

# --- !Downs
DROP TABLE  users.users;
DROP SCHEMA  users;