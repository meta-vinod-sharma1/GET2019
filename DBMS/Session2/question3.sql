
INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-05-05", 17000, "Deliverd", 11, 1);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-05-10", 500, "Deliverd", 11, 2);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-05-15", 17000, "Cancelld", 11, 2);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-05-25", 10000, "Deliverd", 12, 3);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-05-30", 11000, "Cancelled", 13, 4);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-06-05", 8000, "Deliverd", 14, 5);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-06-05", 100, "Cancelled", 14, 5);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-06-19", 15000, "Deliverd", 15, 6);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-06-21", 1000, "Deliverd", 15, 6);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-07-05", 25000, "Deliverd", 16, 7);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-07-06", 7000, "Deliverd", 16, 7);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-07-07", 15000, "Deliverd", 15, 6);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-07-11", 9000, "Deliverd", 15, 6);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-07-12", 22000, "Deliverd", 16, 7);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-07-21", 19000, "Deliverd", 11, 1);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-08-05", 13000, "Deliverd", 11, 2);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-04-05", 11000, "Deliverd", 11, 1);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-08-11", 21000, "Deliverd", 17, 8);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-08-12", 13600, "Deliverd", 11, 2);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-08-16", 19000, "Shipped", 16, 7);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-08-15", 17000, "Shipped", 17, 8);

INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-08-17", 17000, "In Progress", 17, 8);
INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-08-17", 17000, "In Progress", 17, 8);
INSERT INTO ordertable(orderDate,ordertotal,status,shopper_id, address_id)
VALUES("2019-08-18", 17000, "In Progress", 17, 8);


SELECT * FROM ordertable;

/* order items in the order with orderid and quantity */
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES( "DELIVERD", 2, 101, 1 );
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("DELIVERD", 2, 102, 2);

INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("DELIVERD", 3, 105, 2);

INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("DELIVERD", 4, 106, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("DELIVERD", 5, 107, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("CANCELLED", 6, 108, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("SHIPPED", 7, 109, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("CANCELLED", 8, 110, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("DELIVERD", 9, 106, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("DELIVERD", 10, 101, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("SHIPPED", 11, 109, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("DELIVERD", 12, 103, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("DELIVERD", 13, 103, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("CANCELLED", 14, 106, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("IN PROCESS", 15, 107, 1);


INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("SHIPPED", 16, 112, 1);

INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES( "DELIVERD", 19, 107, 1 );
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("DELIVERD", 19, 110, 2);

/* order items for order id 2*/
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES( "SHIPPED", 20, 110, 1 );
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("SHIPPED", 20, 101, 1);

/* order items for order id 21*/
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES( "IN PROCESS", 21, 101, 1 );
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("DELIVERD", 21, 102, 1);

/* order items for order id 22*/
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES( "DELIVERD", 22, 101, 1 );
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("SHIPPED", 22, 102, 2);
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES( "IN PROCESS", 22, 103, 1 );
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES("IN PROCESS", 22, 104, 2);


/* order items for order id 23*/
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
VALUES( "IN PROCESS", 23, 101, 1 );

SELECT* FROM ordersItem;





/* Display Recent 15 Orders placed (Id, Order Date, Order Total) */

SELECT orderid, orderDate, ordertotal
FROM ordertable
ORDER BY orderDate DESC
LIMIT 15;


/* Display 5 most expensive Orders */

SELECT orderid, ordertotal
FROM ordertable
ORDER BY ordertotal DESC
LIMIT 5;

/*Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped. */

SELECT DISTINCT A.orderid,  B.status
FROM ordertable A
INNER JOIN ordersItem B
ON A.orderid = B.orderid 
WHERE  A.orderDate >= DATE_SUB(CURDATE(),INTERVAL 10 DAY) && B.status = "IN PROCESS" ;


/* Display list of shoppers which haven't ordered anything since last month */
/* doubt */
SELECT s.shopper_id, o.orderid, o.orderDate
FROM ordertable o
RIGHT JOIN shopper s
ON s.shopper_id = o.shopper_id
WHERE o.shopper_id IS NULL;

/* 2nd version of above question which giving correct result*/
SELECT s.shopper_id
FROM shopper s
WHERE NOT EXISTS (
    SELECT o.shopper_id
    FROM ordertable o 
    WHERE s.shopper_id = o.shopper_id && o.orderDate >=DATE_SUB(CURDATE(),INTERVAL 1 MONTH) ) ;
    
/* Display list of shopper along with orders placed by them in last 15 days */

SELECT DISTINCT A.shopper_id, B.orderid, C.product_id, C.name, C.price, A.orderDate
FROM ordertable A
INNER JOIN ordersItem B
ON A.orderid = B.orderid
INNER JOIN product C
ON B.product_id = C.product_id
WHERE A.orderDate >= DATE_SUB(CURDATE(), INTERVAL 15 DAY);


/* Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020)) */

SELECT B.orderid, A.product_id, A.name, B.status
FROM product A
INNER JOIN ordersItem B
ON A.product_id = B.product_id
WHERE B.status = "SHIPPED"
ORDER BY B.orderid;

/* Display list of order items along with order placed date which fall between Rs 16000 to Rs 50000 price */
SELECT A.product_id, B.name , B.price, C.orderDate
FROM ordersItem A
INNER JOIN product B
ON A.product_id = B.product_id
INNER JOIN ordertable C
ON C.orderid = A.orderid
Where B.price >=16000 ;