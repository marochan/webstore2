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
  amount int,
  price numeric(20,2),
  primary key (cart_item_id)
);

create table customer_cart_item_ref
(
    customer int references customer(customer_id),
    customer_key int,
    cart_item int references cart_item(cart_item_id) on delete cascade,
    cart_item_key int
);

create table orders
(
    order_id int auto_increment,
    email varchar(128) references customer(email),
    total_price numeric(20,2),
    status varchar(255),
    primary key (order_id)
);

create table order_item
(
    order_item_id int auto_increment,
    customer int references product(product_id),
    amount int,
    price numeric(20,2),
    primary key (order_item_id)
);

create table order_item_ref
(
    order_id int references  orders(order_id),
    order_key int,
    order_item_id int references  order_item(order_item_id) on delete cascade,
    order_item_key int
);