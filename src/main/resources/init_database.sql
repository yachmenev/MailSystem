-- CREATE DATABASE jmail;
DROP SCHEMA IF EXISTS jmail;

CREATE SCHEMA jmail;

use jmail;

DROP TABLE IF EXISTS letters;
DROP TABLE IF EXISTS users;

create table users(
user_id int not null auto_increment,
login varchar(20) not null,
pass varchar(20) not null,
primary key(user_id)
);

create table letters(
letter_id int not null auto_increment,
title varchar(20),
body varchar(20) not null,
to_user int not null,
from_user int not null,
send_date datetime,
primary key(letter_id),
foreign key(to_user) references users(user_id),
foreign key(from_user) references users(user_id)
);

create table contacts(
contact_id int not null auto_increment,
user int not null,
contact int not null,
primary key(contact_id),
foreign key(user) references users(user_id),
foreign key(contact) references users(user_id)
);