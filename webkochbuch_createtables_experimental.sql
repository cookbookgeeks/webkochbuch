CREATE TABLE recipes (
	id serial PRIMARY KEY,
	title varchar(100) NOT NULL,
	description varchar(255) NOT NULL,
	content text NOT NULL,
	preparation_endurance integer NOT NULL,
	total_endurance integer NOT NULL,
	creation timestamp without time zone NOT NULL
);

CREATE TABLE images (
	id serial PRIMARY KEY,
	recipe_id integer REFERENCES recipes(id),
	file_path varchar(255) NOT NULL,
	description varchar(255)
);

CREATE TABLE ratings (
	id serial PRIMARY KEY,
	recipe_id integer REFERENCES recipes(id),
	user_id integer,
	rating integer NOT NULL,
	creation timestamp without time zone NOT NULL
);
