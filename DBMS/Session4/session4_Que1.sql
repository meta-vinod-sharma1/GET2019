
/* Create a function to calculate number of orders in a month. Month and year will be input parameter to function */

use store_front;
DELIMITER |
CREATE FUNCTION numOfOrders ( month INT, year INT) RETURNS INT
        BEGIN
         DECLARE numOfOrders INT(3);
            SELECT COUNT(*) INTO numOfOrders
            FROM ordertable
            WHERE MONTH(orderDate) = month && YEAR(orderDate) = year;
            
         RETURN numOfOrders;
        END|
        
        
SELECT numOfOrders(04,2019), numOfOrders(07,2019), numOfOrders(08,2019), numOfOrders(09,2019) ;




/* Create a function to return month in a year having maximum orders. Year will be input parameter */

DELIMITER |
 CREATE FUNCTION max_order_in_year(year INT) RETURNS VARCHAR(10)
    NOT DETERMINISTIC
     BEGIN
        DECLARE max VARCHAR(10);
            SELECT MONTHNAME(orderDate) INTO max
            FROM ordertable
            WHERE YEAR(orderDate) = year
            GROUP BY MONTH(orderDate)
            ORDER BY COUNT(*) DESC
            LIMIT 1;
        RETURN max;
        END|
        
       
        
        
SELECT max_order_in_year(2019) , max_order_in_year(2018) ;