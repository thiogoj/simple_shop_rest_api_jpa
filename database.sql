use simple_java_rest_api;

create table test (
    id int not null primary key auto_increment
)engine InnoDB;

select * from test;

delete from brands;

create table brands(
    id int not null primary key auto_increment,
    name varchar(100) not null
) engine InnoDB;

select * from brands;

create table products(
    id int not null primary key auto_increment,
    brand_id int not null,
    name varchar(100) not null ,
    description text ,
    price bigint not null ,
    foreign key fk_brands_products (brand_id) references brands(id)
) engine InnoDB;

alter table products
    add column created_at timestamp,
    add column updated_at timestamp;

select *
from products;