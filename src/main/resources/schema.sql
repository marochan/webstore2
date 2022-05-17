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
    price double,
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
  price double,
  primary key (cart_item_id)
);

create table customer_cart_item_ref
(
    customer int references customer(customer_id),
    customer_key int,
    cart_item int references cart_item(cart_item_id) on delete cascade,
    cart_item_key int
);

create table purchase
(
    purchase_id int auto_increment,
    email varchar(128) references customer(email),
    total_price numeric(20,2),
    status varchar(255),
    primary key (purchase_id)
);

create table purchase_item
(
    purchase_item_id int auto_increment,
    product_id int references product(product_id),
    amount int,
    price numeric(20,2),
    primary key (purchase_item_id)
);

create table purchase_item_ref
(
    purchase int references purchase(purchase_id),
    purchase_key int,
    purchase_item int references  purchase_item(purchase_item_id) on delete cascade,
    purchase_item_key   int
);