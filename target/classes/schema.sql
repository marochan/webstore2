create table customer
(
    customer_id int auto_increment,
    email varchar(128) unique,
    password varchar(128),
    primary key (customer_id)
);
create table product
(
    product_id int auto_increment,
    product_name varchar(255),
    amount_available int,
    price numeric(20,2),
    primary key (product_id)
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

create table cart_item
(
  cart_item_id int auto_increment,
  product_id int references product(product_id),
  customer int references customer(customer_id),
  customer_key int,
  amount int,
  price numeric(20,2),
  primary key (cart_item_id)
);

