/* Display Shopper’s information along with number of orders he/she placed during last 30 days*/
SELECT A.userId, A.name, A.email, COUNT(B.shopper_id) AS NumberOfOrders
FROM user A
INNER JOIN ordertable B
ON A.userID = B.shopper_id
WHERE B.orderDate >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
GROUP BY A.userId;


/*Display the top 2 Shoppers who generated maximum number of revenue in last 30 days */

SELECT A.userId, A.name, SUM(B.ordertotal) AS Revenue
FROM user A
INNER JOIN ordertable B
ON A.userId = B.shopper_id
WHERE B.orderDate >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
GROUP BY A.userId
ORDER BY Revenue  DESC
LIMIT 2;

/* Display top 20 Products which are ordered most in last 60 days along with numbers */

SELECT A.product_id, A.name, COUNT(B.product_id) AS NumberOfOrdered
FROM product A
INNER JOIN ordersItem B
ON A.product_id = B.product_id
INNER JOIN ordertable C
ON B.orderid = C.orderid
WHERE C.orderDate >= DATE_SUB(CURDATE(), INTERVAL 60 DAY)
GROUP BY A.product_id
ORDER BY NumberOfOrdered DESC
LIMIT 20;

/* Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale */

SELECT DATE_FORMAT(orderDate, "%m-%y") As month_year, SUM(ordertotal)
FROM ordertable
WHERE orderDate >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)
GROUP BY DATE_FORMAT(orderDate, "%m-%y");

/* Mark the products as Inactive which are not ordered in last 90 days. */

ALTER TABLE product ADD status VARCHAR(10) DEFAULT "active";


SET SQL_SAFE_UPDATES = 0;
UPDATE product
SET status = "Inactive"
WHERE product_id NOT IN(
                SELECT o.product_id
                FROM ordersItem o
                INNER JOIN ordertable ot 
                ON product_id = o.product_id
                WHERE ot.orderDate >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)
);
SET SQL_SAFE_UPDATES = 1;

-- display product table
SELECT* FROM product;
                        

/* Given a category search keyword, display all the Products present in this category/categories */

SELECT product_id, name
FROM product 
WHERE category_id = searchKey;

/* Display top 10 Items which were cancelled most */
SELECT A.product_id, A.name, COUNT(B.product_id) AS countOfCancelled
FROM product A
INNER JOIN ordersItem B
ON A.product_id = B.product_id
WHERE B.status = "CANCELLED"
GROUP BY A.product_id
ORDER BY countOfCancelled DESC;