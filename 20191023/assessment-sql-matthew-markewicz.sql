-- northwind

-- What are the categories of products in the database?
SELECT category FROM products;

-- What products are made by Dell?
SELECT product_name FROM products
WHERE product_name
LIKE '%Dell%';

-- List all the orders shipped to Pennsylvania
SELECT id FROM orders
WHERE ship_state = 'Pennsylvania';

-- List the first name and last name of all employees with last names that start with w
SELECT last_name, first_name FROM employees
WHERE last_name
LIKE 'w%';

-- List all customers from zipcodes that start with 55
SELECT last_name, first_name FROM customers
WHERE postal_code
LIKE '55%';

-- List all customers from zipcodes that end with 0
SELECT last_name, first_name FROM customers
WHERE postal_code
LIKE '%0';

-- List the first name, last name, and email for all customers with a .org email
SELECT first_name, last_name, email FROM customers
WHERE email
LIKE '%.org%';

-- List the first name, last name, and phone number for all customers from the 202 area code
SELECT first_name, last_name, phone FROM customers
WHERE phone
LIKE '%(202)%';

-- List the order id for each order placed by George Wilson
SELECT orders.id FROM orders
INNER JOIN customers
ON orders.customer_id = customers.id
WHERE customer_id = 3;

-- List all the products and quantities associated with order 4003
SELECT * FROM order_details
WHERE order_id = 4003;



-- car_lot

-- add the following cars to the inventory
INSERT INTO car (id, make, model, model_year, color)
VALUES(1, 'Honda', 'Accord', 2012, 'Red'),
(2, 'Chevy', 'Impala', 2017, 'Black'),
(3, 'Ford', 'F-150', 2019, 'Silver'),
(4, 'Subaru', 'Outback', 2020, 'White'),
(5, 'Ford', 'Mustang', 2015, 'Silver'),
(6, 'Honda', 'Ridgeline', 2018, 'Blue'),
(7, 'Chevy', 'Silverado', 2017, 'Gray');

-- Change all Hondas to Black
UPDATE car 
SET color = 'Black'
WHERE make = 'Honda';

-- Change 'Chevy' to 'Cheverolt'
UPDATE car
SET make = 'Cheverolt'
WHERE make = 'Chevy';

-- Change all 2020 model years to 2019
UPDATE car
SET model_year = 2019
WHERE model_year = 2020;

-- Delete alll blue inventory
DELETE FROM car
WHERE color = 'Blue';

-- Delete all Fords
DELETE FROM car
WHERE make = 'Ford';

-- Delete all cars from 2012 and 2017
DELETE FROM car
WHERE model_year < 2017 AND model_year > 2012;