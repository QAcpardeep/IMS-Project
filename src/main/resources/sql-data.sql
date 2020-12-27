INSERT INTO `ims`.`customers` (`first_name`, `surname`) 
VALUES 
('jordan', 'harrison'),
('chetan', 'pardeep'),
('prince', 'masih');
('soham', 'pardeep');



INSERT INTO `ims`.`items` (`name`, `value`) 
VALUES 
('Koch Chemie H8.02 Heavy Cut', '12.49'), 
('Soft99 New Fusso Coat Dark Wax', '29.95'),
('DAS 6 V2 DUAL ACTION POLISHER', '89.95'),
('Bilt Hamber Auto Foam 5L', '17.95'),
('Koch Chemie H11.01 Soft Cut', '12.45');


INSERT INTO `ims`.`orders` (`customer_id`, `cost`) 
VALUES 
('1', '0'),
('3', '0');

INSERT INTO `ims`.`orders_items` (`order_id`, `item_id`) 
VALUES 
('1', '1'),
('2', '1');