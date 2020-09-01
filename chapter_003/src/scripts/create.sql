CREATE DATABASE tracker_database;
\c tracker_database

CREATE TABLE users (
id serial primary key,
name varchar(2000),
age int,
email varchar(100)
);

CREATE TABLE items (
id serial primary key,
name varchar(2000)
);

CREATE TABLE comments (
id serial primary key,
comment varchar(2000),
comment_id int references items(id)
);

CREATE TABLE state (
id serial primary key,
state_name varchar(100),
state_id int references items(id)
);

CREATE TABLE attachments (
id serial primary key,
file varchar(2000),
file_id int references items(id)
);

CREATE TABLE category (
id serial primary key,
category_name varchar(2000),
category_id int references items(id)
);

CREATE TABLE role (
role_type varchar(200) primary key,
users_id int references users(id)
);

CREATE TABLE rule (
rule_type varchar(2000) primary key,
rule_description varchar(2000)
);

CREATE TABLE role_rule (
id serial primary key,
rule_type varchar(2000) references rule(rule_type),
role_type varchar(2000) references role(role_type)
);

INSERT INTO users(name, age, email) VALUES ('Ivan', 22, 'ivan@gmail.com');
INSERT INTO users(name, age, email) VALUES ('Aleksand', 42, 'alex@yandex.ru');

INSERT INTO items(name) VALUES ('Bug number 1');
INSERT INTO items(name) VALUES ('Bug number 2');

INSERT INTO comments(comment, comment_id) VALUES ('Ne rabotaet knopka', 1);
INSERT INTO comments(comment, comment_id) VALUES ('Ne rabotaet menu', 2);

INSERT INTO state(state_name, state_id) VALUES ('Accepted in work', 1);
INSERT INTO state(state_name, state_id) VALUES ('Cancelled', 2);

INSERT INTO attachments(file, file_id) VALUES ('Vot eta knopka.png', 1);
INSERT INTO attachments(file, file_id) VALUES ('Vot et menu.png', 2);

INSERT INTO category(category_name, category_id) VALUES ('serious', 1);
INSERT INTO category(category_name, category_id) VALUES ('regular', 2);

INSERT INTO role(role_type, users_id) VALUES ('user', 1);
INSERT INTO role(role_type, users_id) VALUES ('admin', 2);

INSERT INTO rule(rule_type, rule_description) VALUES ('user_rules', 'Grants prava usera');
INSERT INTO rule(rule_type, rule_description) VALUES ('admin_rules', 'Grants prava admina');

INSERT INTO role_rule(rule_type, role_type) VALUES ('user_rules', 'user');
INSERT INTO role_rule(rule_type, role_type) VALUES ('admin_rules', 'admin');