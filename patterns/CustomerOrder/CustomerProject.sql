DROP TABLE IF EXISTS cp_order_item;
DROP TABLE IF EXISTS cp_order;
DROP TABLE IF EXISTS cp_customer;
DROP TABLE IF EXISTS cp_product;

CREATE TABLE cp_product
(
	product_id SERIAL PRIMARY KEY,
	product_name varchar(100),
	product_price numeric
);

CREATE TABLE cp_customer
(
	customer_id varchar(100) PRIMARY KEY,
	first_name varchar(100),
	last_name varchar(100),
	email varchar(100)
);

CREATE TABLE cp_order
(
	order_id SERIAL PRIMARY KEY,
	customer_id varchar(100) REFERENCES cp_customer (customer_id),
	order_number varchar(100),
	order_status integer
);

CREATE TABLE cp_order_item
(
	order_item_id SERIAL PRIMARY KEY,
	order_id integer REFERENCES cp_order (order_id),
	product_id integer REFERENCES cp_product (product_id),
	quantity integer,
	price numeric
);