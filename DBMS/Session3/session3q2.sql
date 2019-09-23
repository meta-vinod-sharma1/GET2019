INSERT INTO product_category(product_id, category_id)
Values(101,8),
(102,7),
(103,7),
(104,8),
(105,4),
(106,9),
(107,9),
(108,9),
(109,4),
(110,5),
(110,6),
(111,5),
(111,6),
(112,5),
(112,6),
(113,5),
(114,5),
(114,6);





-- SET SQL_SAFE_UPDATES = 0;
-- DELETE FROM product_category;
-- SET SQL_SAFE_UPDATES = 1;
-- 



/* Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories. */

SELECT p.product_id AS Id, p.name AS Title, COUNT(pc.product_id) AS CountOfCategories
FROM product_category pc
INNER JOIN product p 
ON p.product_id = pc.product_id
GROUP BY p.product_id
HAVING CountOfCategories > 1;


/* COUNT of PRODUCT IN PRICE RANGE */
SELECT CASE
    WHEN price BETWEEN 0 AND 10000 THEN '0-1000'
    WHEN price BETWEEN 10001 AND 20000 THEN '10001-20000'
    ELSE "Above 20000"
        END AS RangeInRs , COUNT(price)
FROM product
GROUP BY RangeInRs;



/* Display the Categories along with number of products under each category */
SELECT c.name AS Category, COUNT(pc.product_id) AS numOfProducts
FROM product_category pc
INNER JOIN category c
ON c.id = pc.category_id
GROUP BY Category;