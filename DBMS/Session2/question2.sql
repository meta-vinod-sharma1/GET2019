
/* 15 enteries of user table */
INSERT INTO user(userId,name, password, email) VALUES(11,"Shobhit", "9660360364429","shobhit@gmail.com");
INSERT INTO user(userId,name, password, email) VALUES(12,"Rakesh", "123456", "rakesh@gmail.com");
INSERT INTO user(userId,name, password, email) VALUES(13,"Gaurav", "123456", "gaurav@metacube.com");
INSERT INTO user(userId,name, password, email) VALUES(14,"Rahul", "123456", "rahul@metacube.com");
INSERT INTO user(userId,name, password, email) VALUES(15,"Vinod", "123456", "vinod@metacube.com");
INSERT INTO user(userId,name, password, email) VALUES(16,"Ankita", "123456", "Ankita@metacube.com");
INSERT INTO user(userId,name, password, email) VALUES(17,"Yatika", "123456", "Yatika@metacube.com");
INSERT INTO user(userId,name, password, email) VALUES(18,"Vikas", "123456", "Vikas@gmail.com");
INSERT INTO user(userId,name, password, email) VALUES(19,"Shubham", "123456", "Shubham1323q4@gmail.com");
INSERT INTO user(userId,name, password, email) VALUES(20,"Ansul", "123456", "Ansul@yahoo.com");
INSERT INTO user(userId,name, password, email) VALUES(25,"Ansul", "123456", "Ansul@yahoo.com");
INSERT INTO user(userId,name, password, email) VALUES(21,"MUKESH", "123456", "Mukesh@yahoo.com");
INSERT INTO user(userId,name, password, email) VALUES(22,"user1", "123456", "user1@yahoo.com");
INSERT INTO user(userId,name, password, email) VALUES(23,"user2", "123456", "user2@yahoo.com");
INSERT INTO user(userId,name, password, email) VALUES(24,"user3", "123456", "user3@yahoo.com");

/* display user table*/
SELECT * FROM user;


/* 10 enteries of shopper table which also link with user table by shopper_id */
INSERT INTO shopper(shopper_id, phone_no, sex) VALUES(11,966036442,"male");
INSERT INTO shopper(shopper_id, phone_no, sex) VALUES(12,966036441,"male");
INSERT INTO shopper(shopper_id, phone_no, sex) VALUES(13,966036443,"male");
INSERT INTO shopper(shopper_id, phone_no, sex) VALUES(14,778899556,"male");
INSERT INTO shopper(shopper_id, phone_no, sex) VALUES(15,986365646,"male");
INSERT INTO shopper(shopper_id, phone_no, sex) VALUES(16,866036443,"male");
INSERT INTO shopper(shopper_id, phone_no, sex) VALUES(17,775531531,"male");
INSERT INTO shopper(shopper_id, phone_no, sex) VALUES(18,823245646,"male");
INSERT INTO shopper(shopper_id, phone_no, sex) VALUES(19,853245646,"male");
INSERT INTO shopper(shopper_id, phone_no, sex) VALUES(20,145431654,"male");

/* entries Address of users */

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("Anantpura","Jaipur", "Rajasthan", 323507, 11);

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("JAITPURA","Jaipur", "Rajasthan", 323502, 11);

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("RAJA PARK","Jaipur", "Rajasthan",323206, 12);

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("SITAPURA","Jaipur", "Rajasthan", 323509,13);

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("Anantpura","kota", "Rajasthan", 323521,14);

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("hello","jodhpur", "Rajasthan",3235377, 15);

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("malviya nagar","Jaipur", "Rajasthan",323624, 16);

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("RAJA PARK","ajmer", "Rajasthan",323563, 17);

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("RAJA PARK","alwar", "Rajasthan",323573, 18);

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("sashtri nagar","Jaipur", "Rajasthan",323519, 19);

INSERT INTO address(street, district, state, pincode, shopper_id)
VALUES("mansarover","Jaipur", "Rajasthan",323787, 20);

/* Display address of shoppers*/
select * from address;

/* display shopper table*/
SELECT * FROM shopper;

/* user table and shopper table combine with left join*/
Select userId,name,email,phone_no,sex
FROM user
LEFT JOIN shopper
ON user.userId = shopper.shopper_id;

/* Category */
INSERT INTO category(id,name) VALUES(1,"Electronics");
INSERT INTO category(id,name) VALUES(2,"Appreal");
INSERT INTO category(id,name,parent_id) VALUES(3,"Mobile",1);
INSERT INTO category(id,name,parent_id) VALUES(4,"TV",1);
INSERT INTO category(id,name,parent_id) VALUES(5,"Men's",2);
INSERT INTO category(id,name,parent_id) VALUES(6,"Women's",2);
INSERT INTO category(id,name,parent_id) VALUES(7,"Apple",3);
INSERT INTO category(id,name,parent_id) VALUES(8,"Nokia",3);
INSERT INTO category(id,name,parent_id) VALUES(9,"MI",3);


describe category;
/*display categories with parent category using self join*/

SELECT A.id as categoryId, A.name as CategoryName, IFNULL(B.name, 'Top Category') as ParentCategory
FROM category A
LEFT JOIN category B
ON A.parent_id = B.id;
 


/* inserting 14 products with diffrent diffrent category with price */
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(101, 15000 ,"Nokia 6.1 plus","Android phone with 6 inch screen", 8 , "2019-08-16");
    
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(102, 25000 ,"iphone 5s","4 Gb Ram and 64 gb storage", 7, "2019-08-10");
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(103, 45000 ,"iphone 6s","4 Gb Ram and 64 gb storage", 7 , "2019-08-10");
    
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(104, 22000 ,"Nokia 7.1 plus","4 Gb Ram and 64 gb storage", 8 , "2019-08-02");
    
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(105, 25000 ,"Samsung Led Tv","32 inch", 4 , "2019-07-15");

INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(106, 15000 ,"MI NOTE 4","4 Gb Ram and 64 gb storage", 9 , "2019-03-10");
    
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(107, 20000 ,"MI NOTE 5","6 Gb Ram and 128 gb storage", 9 , "2019-04-10");
    
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(108, 22000 ,"MI NOTE 6 PRO ","4 Gb Ram and 256 gb storage", 9 , "2019-07-10");

INSERT INTO product(product_id, price, name, description, category_id,date)     
    Values(109, 35000 ,"led Sony","44 inch", 4 , "2019-08-16");
    
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(110, 2000 ,"Black shirt Mens","cotten shirt", 5 , "2019-01-10");
    
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(111, 5000 ,"Women Skirt","Summer skirt with full comfort", 6 , "2019-01-9");
    
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(112, 250 ,"Men's Tshirt","V nech", 5 , "2018-08-10");
    
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(113, 25000 ,"Men's suit","Raymond suit", 5 , "2019-08-11");
    
INSERT INTO product(product_id, price, name, description, category_id,date) 
    Values(114, 150 ,"Women Scarp","fully comfort scarp", 6 , "2019-08-10");
   
/* PRODUCT DISPLAY in date decending order */   
SELECT * FROM product
ORDER BY date DESC ;

/* Images Insert for Products */
INSERT INTO image(product_id,img)
    Values(101,"1.jpg");
  INSERT INTO image(product_id,img)
    Values(101,"2.jpg");
  INSERT INTO image(product_id,img)
    Values(102,"1.jpg");
  INSERT INTO image(product_id,img)
    Values(104,"1.jpg");
 INSERT INTO image(product_id,img)
    Values(105,"1.jpg");
  INSERT INTO image(product_id,img)
    Values(107,"1.jpg");
  INSERT INTO image(product_id,img)
    Values(110,"1.jpg");
  INSERT INTO image(product_id,img)
    Values(114,"1.jpg");
  INSERT INTO image(product_id,img)
    Values(114,"2.jpg");
  INSERT INTO image(product_id,img)
    Values(114,"3.jpg");
  
SELECT * FROM image;

/* products inserting into stock with quantity and date*/
INSERT INTO stock(product_id, quantity, date_added)
Values(101,70,"2019-08-15");

INSERT INTO stock(product_id, quantity, date_added)
Values(102,40,"2019-08-12");

INSERT INTO stock(product_id, quantity, date_added)
Values(103,10,"2019-08-11");

INSERT INTO stock(product_id, quantity, date_added)
Values(104,1,"2019-08-10");

INSERT INTO stock(product_id, quantity, date_added)
Values(105,90,"2019-08-16");

INSERT INTO stock(product_id, quantity, date_added)
Values(106,91,"2019-08-12");

INSERT INTO stock(product_id, quantity, date_added)
Values(107,500,"2019-08-01");

INSERT INTO stock(product_id, quantity, date_added)
Values(108,210,"2019-08-03");

INSERT INTO stock(product_id, quantity, date_added)
Values(109,80,"2019-08-08");

INSERT INTO stock(product_id, quantity, date_added)
Values(110,2,"2019-08-17");

INSERT INTO stock(product_id, quantity, date_added)
Values(112,65,"2019-08-07");

INSERT INTO stock(product_id, quantity, date_added)
Values(113,50,"2019-08-06");
INSERT INTO stock(product_id, quantity, date_added)
Values(114,25,"2019-08-02");

SELECT * FROM stok;


/* Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top. */
SELECT A.product_id as Id, A.description as Title, B.name as Category, A.price as Price
From product A
LEFT JOIN category B
ON A.category_id = B.id;

/* Display the list of products which don't have any images */

SELECT DISTINCT A.product_id as Id, A.name as Name
From product A
WHERE NOT EXISTS(
    SELECT m.product_id
    FROM image m
    WHERE A.product_id = m.product_id
);


/* Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title.
(If Category is top category then Parent Category Title column should display “Top Category” as value.) */

SELECT A.id as categoryId, A.name as CategoryName, IFNULL(B.name, 'Top Category') as ParentCategory
FROM category A
LEFT JOIN category B
ON A.parent_id = B.id;

/*  Display Id, Title, Parent Category Title of all the leaf Categories(categories which are not parent of any other category) */
SELECT A.id as categoryId, A.name as CategoryName, IFNULL(B.name, 'Top Category') as ParentCategory
FROM category A 
LEFT JOIN category B
ON A.parent_id = B.id
WHERE NOT EXISTS(
    SELECT C.id
    FROM category C
    WHERE A.id = C.parent_id
);

/* Display Product Title, Price & Description which falls into particular category Title */
SELECT product.name , product.price, product.description, A.name
From product
LEFT JOIN category A
ON product.category_id = A.id
where A.name = "MI";




/* Display the list of Products whose Quantity on hand (Inventory) is under 50 */
SELECT A.product_id, A.name, IFNULL(B.quantity, 0) AS quantity
FROM product A
LEFT JOIN stock B
ON A.product_id = B.product_id
WHERE B.quantity <= 50;


