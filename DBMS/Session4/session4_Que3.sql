
-- Identify the columns require indexing in order, product, category tables and create indexes.;

-- In order table we should can use indexing on orderDate, or on shopper_id.

-- In Product table we can set indexing on category_id generally we search product by category 

-- In Category id we can indexing on parent_id we search categories by it's parent_id


ALTER TABLE ordertable ADD INDEX shopper(shopper_id);
ALTER TABLE product ADD INDEX Category(category_id);
ALTER TABLE category ADD INDEX parent(parent_id);