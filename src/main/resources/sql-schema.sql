DROP DATABASE ims;

CREATE DATABASE ims;

USE ims;

CREATE TABLE IF NOT EXISTS customers (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(255) NOT NULL,
	surname VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS items (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	value DOUBLE(6,2) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS orders (
	id INT NOT NULL AUTO_INCREMENT,
	customer_id INT NOT NULL,
	cost DOUBLE(6,2) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS orders_items (
	id INT NOT NULL AUTO_INCREMENT,
	order_id INT NOT NULL,
	item_id INT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
	FOREIGN KEY (item_id) REFERENCES items(id)
);





