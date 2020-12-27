INSERT INTO `customers` (`first_name`, `surname`) 
VALUES 
('jordan', 'harrison'),
('chetan', 'pardeep'),
('soham', 'pardeep');

INSERT INTO `items` (`name`, `value`) 
VALUES 
('clay bar', '9.99'),
('snow foam', '39.99'),
('tyre dressing', '15.99');

INSERT INTO `orders` (`customer_id`, `cost`) 
VALUES 
('1', '9.99'),
('2', '39.99');

INSERT INTO `orders_items` (`order_id`, `item_id`) 
VALUES 
('1', '1'),
('1', '2'),
('1', '3'),
('2', '1'),
('2', '2');

SELECT SUM(items.value) FROM items JOIN orders_items ON orders_items.item_id = items.id GROUP BY orders_items.order_id HAVING orders_items.order_id = 1;



