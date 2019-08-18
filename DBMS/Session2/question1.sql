
CREATE DATABASE store_front;

USE store_front;


CREATE TABLE user(
    userId INT NOT NULL,
    name VARCHAR(100),
    password VARCHAR(15),
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY(userId)
);

CREATE TABLE admin(
    adminId INT NOT NULL,
    PRIMARY KEY(adminId),
    FOREIGN KEY(adminId) REFERENCES user(userId)
);

CREATE TABLE shopper(
    shopper_id INT,
    phone_no INT NOT NULL,
    sex VARCHAR(5) NOT NULL,
    FOREIGN KEY(shopper_id) REFERENCES user(userId)
);
CREATE TABLE address(
    address_id INT NOT NULL AUTO_INCREMENT,
    street VARCHAR(15),
    district VARCHAR(25),
    state VARCHAR(25),
    pincode INT(6) NOT NULL,
    shopper_id Int,
    PRIMARY KEY(address_id),
    FOREIGN KEY(shopper_id) REFERENCES shopper(shopper_id)
    
);
CREATE TABLE product(
    product_id INT,
    price FLOAT(20) NOT NULL,
    name VARCHAR(25) NOT NULL,
    description VARCHAR(35) NOT NULL,
    category_id INT,
    date Date,
    PRIMARY KEY(product_id),
    FOREIGN KEY(category_id) REFERENCES category(id)
    
);

CREATE TABLE image(
    product_id Int,
    img VARCHAR(150),
    FOREIGN KEY(product_id) REFERENCES product(product_id)
    
);
show tables;


CREATE TABLE category(
    id INT NOT NULL,
    name VARCHAR(30) NOT NULL,
    parent_id INT,
    FOREIGN KEY(parent_id) REFERENCES category(id),
    PRIMARY KEY(id)
);


CREATE TABLE stock(
    product_id INT, 
    quantity INT DEFAULT 0,
    date_added Date,
    FOREIGN KEY(product_id) REFERENCES product(product_id)
    
);

CREATE TABLE cart(
    product_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY(product_id) REFERENCES stock(product_id)
    
);

CREATE TABLE ordertable(
    orderid INT NOT NULL AUTO_INCREMENT,
    orderDate Date,
    ordertotal INT NOT NULL,
    status VARCHAR(15) NOT NULL,
    shopper_id INT,
    address_id INT,
    PRIMARY KEY(orderid),
    FOREIGN KEY(shopper_id) REFERENCES shopper(shopper_id),
    FOREIGN KEY(address_id) REFERENCES address(address_id)
);
CREATE TABLE ordersItem(
    status VARCHAR(30) NOT NULL DEFAULT "IN PROCESS",
    orderid INT,
    product_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY(orderid) REFERENCES ordertable(orderid),
    FOREIGN KEY(product_id) REFERENCES product(product_id)
);
/* display all tables*/
show tables;

