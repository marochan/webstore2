create table customer
(
    customer_id int auto_increment,
    email varchar(128) unique,
    password varchar(128),
    primary key (customer_id)
);

create table roles
(
    role_id int auto_increment,
    name varchar(128),
    primary key (role_id)
);
create table customer_role_ref
(
    customer int references customer(customer_id),
    customer_key int,
    roles int references roles(role_id),
    roles_key int
);