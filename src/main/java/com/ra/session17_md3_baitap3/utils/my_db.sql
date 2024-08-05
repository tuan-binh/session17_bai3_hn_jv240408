create database session17_md3_baitap3;
use session17_md3_baitap3;

create table category
(
    id     int auto_increment primary key,
    name   varchar(255),
    status bit
);

create table product
(
    id          int auto_increment primary key,
    name        varchar(255),
    price       double,
    stock       int,
    category_id int,
    status      bit,
    foreign key (category_id) references category (id)
);