/* Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status)
with latest ordered items should be displayed first for last 60 day*/

CREATE VIEW order_info AS
SELECT O.orderid AS ID, P.product_id AS product_id , P.name AS Title , P.price, U.name AS Shopper_Name, U.email, O.orderDate, I.status
FROM ordertable O
INNER JOIN ordersItem I
ON O.orderid = I.orderid
INNER JOIN product P
ON I.product_id = P.product_id
INNER JOIN user U
ON O.shopper_id = U.userId
WHERE O.orderDate >= DATE_SUB(CURDATE(), INTERVAL 60 DAY)
ORDER BY O.orderDate DESC;


/* displaying view */
SELECT * FROM order_info;


/* Use the above view to display the Products(Items) which are in ‘shipped’ state*/

SELECT product_id, Title AS Product, status
FROM order_info
WHERE status = "SHIPPED";


/* Use the above view to display the top 5 most selling products */

SELECT product_id, Title , COUNT(product_id) AS no_of_sale
FROM order_info
GROUP BY product_id
ORDER BY no_of_sale DESC
LIMIT 5;