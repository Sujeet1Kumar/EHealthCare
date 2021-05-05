# EHealthCare
This Project is Based on Servlet & Jsp

Mysql tables are:

create table login(id varchar(10) primary key, password varchar(25), role varchar(10));

create table doctor(id varchar(10) primary key, name varchar(25), mobile varchar(10), email varchar(25), exp varchar(10), qual varchar(50), spec varchar(25), image varchar(25));

create table patient(id varchar(10) primary key, name varchar(25), mobile varchar(10), email varchar(25), address varchar(50), gender varchar(10), issue varchar(25), image varchar(25));

create table feedback(pid varchar(10), did varchar(10), rate varchar(10), comment varchar(100), pname varchar(25), dname varchar(25), pimage varchar(25), dimage varchar(25));

create table chatting (chat varchar(100));

create table request (pid varchar(10), did varchar(10), status varchar(10));
