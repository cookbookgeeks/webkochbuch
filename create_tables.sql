/*
 * This SQL Script will create all tables and user roles needed for 
 * the webkochbuch application.
 *
 * Copyright (C) cookbookgeeks, 2014
 * Author: Florian Knecht
 *
 */

--
-- Remove all tables and users needed, if they already exist.
--

DROP TABLE t_categories;
DROP TABLE t_recipes;
DROP TABLE t_users;
DROP TABLE t_images;
DROP TABLE t_measures;
DROP TABLE t_comments;
DROP TABLE t_ingredients;
DROP TABLE t_ratings;
DROP SEQUENCE hibernate_sequence;
DROP USER wkb_app_user;


--
-- Webkochbuch will use this user to access the database.
-- This user has limited rights. He is allowed to to CRUD
-- operations on database contents but has no superuser
-- rights.
--
CREATE USER wkb_app_user WITH PASSWORD 'Ahawolq7RuTTAGCyWML6';


CREATE TABLE t_users
(
  id integer NOT NULL,
  username character varying(50) NOT NULL,
  password_hash character varying(255) NOT NULL,
  e_mail character varying(255) NOT NULL,
  creation_date timestamp without time zone NOT NULL,
  last_edit timestamp without time zone NOT NULL,
  CONSTRAINT t_users_int_pkey PRIMARY KEY (id)
);

GRANT SELECT,INSERT,UPDATE,DELETE ON t_users TO wkb_app_user;


CREATE TABLE t_categories
(
  id integer NOT NULL,
  name character varying(255) NOT NULL,
  CONSTRAINT t_categories_pkey PRIMARY KEY (id)
);

GRANT SELECT,INSERT,UPDATE,DELETE ON t_categories TO wkb_app_user;


CREATE TABLE t_recipes
(
  id integer NOT NULL,
  title character varying(100) NOT NULL,
  description character varying(255) NOT NULL,
  content text NOT NULL,
  preparation_endurance integer NOT NULL,
  total_endurance integer NOT NULL,
  creation_date timestamp without time zone NOT NULL,
  last_edit timestamp without time zone NOT NULL,
  category_id integer,
  user_id integer NOT NULL,
  CONSTRAINT t_recipes_pkey PRIMARY KEY (id),
  CONSTRAINT t_recipes_category_id_fkey FOREIGN KEY (category_id)
      REFERENCES t_categories (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT t_recipes_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES t_users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

GRANT SELECT,INSERT,UPDATE,DELETE ON t_recipes TO wkb_app_user;


CREATE TABLE t_images
(
  id integer NOT NULL,
  file_path character varying(255) NOT NULL,
  description character varying(255) NOT NULL,
  user_id integer NOT NULL,
  recipe_id integer,
  creation_date timestamp without time zone NOT NULL,
  last_edit timestamp without time zone NOT NULL,
  CONSTRAINT t_images_pkey PRIMARY KEY (id),
  CONSTRAINT t_images_recipe_id_fkey FOREIGN KEY (recipe_id)
      REFERENCES t_recipes (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT t_images_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES t_users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

GRANT SELECT,INSERT,UPDATE,DELETE ON t_images TO wkb_app_user;


CREATE TABLE t_measures
(
  id integer NOT NULL,
  name character varying(255) NOT NULL,
  CONSTRAINT t_measures_pkey PRIMARY KEY (id)
);

GRANT SELECT,INSERT,UPDATE,DELETE ON t_measures TO wkb_app_user;


CREATE TABLE t_comments
(
  id integer NOT NULL,
  comment text NOT NULL,
  user_id integer NOT NULL,
  recipe_id integer NOT NULL,
  creation_date timestamp without time zone NOT NULL,
  last_edit timestamp without time zone NOT NULL,
  CONSTRAINT t_comments_pkey PRIMARY KEY (id),
  CONSTRAINT t_images_recipe_id_fkey FOREIGN KEY (recipe_id)
      REFERENCES t_recipes (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT t_images_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES t_users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

GRANT SELECT,INSERT,UPDATE,DELETE ON t_comments TO wkb_app_user;


CREATE TABLE t_ingredients
(
  id integer NOT NULL,
  name character varying(255) NOT NULL,
  measure_id integer NOT NULL,
  amount double precision NOT NULL,
  recipe_id integer NOT NULL,
  creation_date timestamp without time zone NOT NULL,
  last_edit timestamp without time zone NOT NULL,
  CONSTRAINT t_ingredients_pkey PRIMARY KEY (id),
  CONSTRAINT t_ingredients_measure_id_fkey FOREIGN KEY (measure_id)
      REFERENCES t_measures (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT t_ingredients_recipe_id_fkey FOREIGN KEY (recipe_id)
      REFERENCES t_recipes (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

GRANT SELECT,INSERT,UPDATE,DELETE ON t_ingredients TO wkb_app_user;


CREATE TABLE t_ratings
(
  id integer NOT NULL,
  user_id integer NOT NULL,
  recipe_id integer NOT NULL,
  rating integer NOT NULL,
  creation_date timestamp without time zone NOT NULL,
  last_edit timestamp without time zone NOT NULL,
  CONSTRAINT t_ratings_pkey PRIMARY KEY (id),
  CONSTRAINT t_ratings_recipe_id_fkey FOREIGN KEY (recipe_id)
      REFERENCES t_recipes (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT t_ratings_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES t_users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

GRANT SELECT,INSERT,UPDATE,DELETE ON t_ratings TO wkb_app_user;


--
-- This sequence is used by hibernate to increment id values
-- of newly inserted entries.
--

CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 100000;
  
GRANT USAGE ON hibernate_sequence TO wkb_app_user;


--
-- Temporarily needed dummy entries:
--

INSERT INTO t_users VALUES (0,'dummyuser','hashstring','dummy@example.org',now(),now());


--
-- Content, needed to run webkochbuch usefully.
--

INSERT INTO t_categories VALUES (0, 'Kochen');
INSERT INTO t_categories VALUES (1, 'Backen');
INSERT INTO t_categories VALUES (2, 'Dessert');
