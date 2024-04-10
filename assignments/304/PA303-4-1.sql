-- Practice Assignment 304.4.1 Simple Queries

-- Display the name, product line, and buy price of all products. The output columns should 
-- display as: “Name,” “Product Line,” and “Buy Price.” The output should display the most expensive items first. 
SELECT productName Name, productLine 'Product Line', buyPrice 'Buy Price' from products ORDER BY buyPrice desc;

-- Display the first name, last name, and city name of all customers from Germany. The output columns should display 
-- as: “First Name,” “Last Name,” and “City.” The output should be sorted by “Last Name” (ascending).
SELECT contactFirstName 'First Name', contactLastName 'Last Name', city 'City' FROM customers ORDER BY contactLastName;

-- Display each of the unique values of the status field in the orders table. The output should be sorted alphabetically, ascending.
-- Hint: The output should show exactly six rows.
SELECT DISTINCT(status) FROM orders ORDER BY status;

-- Display all fields from the payments table for payments made on or after January 1, 2005.
-- The output should be sorted by the payment date from highest to lowest.
SELECT * FROM payments WHERE paymentDate > '2005-01-01' ORDER BY paymentDate DESC;

-- Display the last Name, first Name, email address, and job title of all employees working out of the San Francisco office. 
-- The output should be sorted by “Last Name.”
SELECT lastName, firstName, email, jobTitle FROM employees
JOIN offices ON employees.officeCode = offices.officeCode
WHERE offices.city like 'San Francisco'
ORDER BY employees.lastName;

-- Display the name, product line, scale, and vendor of all of the car products – both classic and vintage. 
-- The output should display all vintage cars first (sorted alphabetically by name), and all classic cars last (also sorted alphabetically by name). 
SELECT productname, productline, productscale, productvendor FROM products WHERE productline like 'cl%' OR productline like 'vin%' ORDER BY  productline DESC, productName; 
SELECT productname, productline, productscale, productvendor FROM products WHERE productline in ('Classic Cars', 'Vintage Cars') ORDER BY  productline DESC, productName; 



