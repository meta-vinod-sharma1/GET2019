/* */
  
INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES
("Talwandi","kota", "Rajasthan", 323507, 15),
("sultanpur","kanpur", "UP", 323557, 16),
("sultanpur","sultanpur", "UP", 323646, 18),
("sultanpur","lucknow", "UP", 323565, 19),
("KLHFA","Manesar", "Haryana", 423507, 17),
("home","rewadi", "haryana", 323507, 11),
("Anat","indore", "mp", 323507, 11),
("xyz","jabalpur", "mp", 393654, 11),
("road no 2","chandigarh", "punjab", 323893, 19);
  
SELECT DISTINCT CONCAT( street , ', ' , district, ', ' , state, ', ' , pincode) AS address
FROM address
ORDER BY state, district;