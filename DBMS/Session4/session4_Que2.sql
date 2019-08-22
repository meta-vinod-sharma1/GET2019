USE store_front;


#1.Stored procedure to retrieve average sales of each product in a month
DELIMITER &&

CREATE PROCEDURE average_sales(month INT, year INT)
BEGIN

DECLARE total_product INT; 

SELECT COUNT(*) INTO total_product
FROM ordersItem o
INNER JOIN ordertable ot
ON o.orderid = ot.orderid
WHERE MONTH(ot.orderDate) = month AND YEAR(ot.orderDate) = year;

SELECT o.product_id,COUNT(*) / total_product AS average
FROM ordersItem o
INNER JOIN ordertable ot
ON ot.orderid = o.orderid
WHERE MONTH(ot.orderDate) = month AND YEAR(ot.orderDate) = year
GROUP BY o.product_id;

END &&
DELIMITER ;

CALL average_sales(08,2019);



#2.Stored procedure to retrieve table having order detail with status for a given period
DELIMITER $$
CREATE PROCEDURE ordersOfTheGivenPeriod(start_date DATE, end_date DATE)
  BEGIN
      IF start_date > end_date
          THEN SET start_date = DATE_ADD(DATE_ADD(LAST_DAY(end_date),INTERVAL 1 DAY),INTERVAL - 1 MONTH);
      END IF;
      SELECT o.orderid, o.orderDate, o.ordertotal, o.status
      FROM ordertable o 
      WHERE o.orderDate BETWEEN start_date AND end_date
      ORDER BY o.orderDate DESC;
  END $$

-- first case

CALL ordersOfTheGivenPeriod('2019-08-03','2019-07-12');

-- second case
CALL ordersOfTheGivenPeriod('2019-07-01','2019-08-22');

-- third case 
CALL ordersOfTheGivenPeriod('2019-08-01','2019-06-22');




