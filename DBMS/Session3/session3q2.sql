/* COUNT of PRODUCT IN PRICE RANGE */
SELECT COUNT(price)
FROM product
WHERE price BETWEEN 0 AND 10000;

SELECT COUNT(price)
FROM product
WHERE price BETWEEN 10001 AND 20000;

SELECT COUNT(price)
FROM product
WHERE price >= 20000;


/* Display the Categories along with number of products under each category */
SELECT A.name, COUNT(B.category_id)
FROM category A
INNER JOIN product B
ON A.id = B.category_id
GROUP BY A.name;