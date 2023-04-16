INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1005', 'RED SHIRT', 'A red shirt','hanes', 'v neck', '49.99', 'XL', '10', 'temp1');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1004', 'BLUE SHIRT', 'A blue shirt', 'hanes', 'v neck', '49.99', 'XL', '10', 'temp2');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1002', 'GREEN SHIRT', 'A green shirt','hanes', 'v neck', '49.99', 'XL', '10', 'temp3');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1003', 'YELLOW SHIRT', 'A yellow shirt','hanes', 'v neck', '49.99', 'XL', '10', 'temp4');

INSERT INTO shirt(type, product_id)
VALUES(2,'1005');
INSERT INTO shirt(type, product_id)
VALUES(2,'1004');
INSERT INTO shirt(type, product_id)
VALUES(2,'1003');
INSERT INTO shirt(type, product_id)
VALUES(2,'1002');
INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1006', 'RED PANTS', 'A red pair of pants','Levis', 'boot cut', '49.99', '32W 30L', '10', 'temp5');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1007', 'BLUE PANTS', 'A blue pair of pants','Levis', 'boot cut', '49.99', '32W 30L', '10', 'temp6');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1008', 'GREEN PANTS', 'A green pair of pants','Levis', 'boot cut', '49.99', '32W 30L', '10', 'temp7');
INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1009', 'YELLOW PANTS', 'A yellow pair of pants','Levis', 'boot cut', '49.99', '32W 30L', '10', 'temp8');

INSERT INTO pants(type, product_id, beltloops, pockets, zipper)
VALUES(2,'1006', true, true, true);
INSERT INTO pants(type, product_id, beltloops, pockets, zipper)
VALUES(2,'1007', true, true, true);
INSERT INTO pants(type, product_id, beltloops, pockets, zipper)
VALUES(2,'1008', true, true, true);
INSERT INTO pants(type, product_id, beltloops, pockets, zipper)
VALUES(2,'1009', true, true, true);

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1010', 'RED HAT', 'A red hat','Zumiez', 'Snapback', '49.99', 'large', '10', 'temp9');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1011', 'BLUE HAT', 'A blue hat','Zumiez', 'Snapback', '49.99', 'large', '10', 'temp10');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1012', 'GREEN HAT', 'A green hat','Zumiez', 'Snapback', '49.99', 'large', '10', 'temp11');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1013', 'YELLOW HAT', 'A yellow hat','Zumiez', 'Snapback', '49.99', 'large', '10', 'temp12');


INSERT INTO hat(type, product_id)
VALUES(2,'1010');
INSERT INTO hat(type, product_id)
VALUES(2,'1011');
INSERT INTO hat(type, product_id)
VALUES(2,'1012');
INSERT INTO hat(type, product_id)
VALUES(2,'1013');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1014', 'RED SHOES', 'Red shoes','Adidas', 'Hightop', '49.99', '11', '10', 'temp13');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1015', 'BLUE SHOES', 'Blue Shoes','Adidas', 'Hightop', '49.99', '11', '10', 'temp14');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1016', 'GREEN SHOES', 'Green Shoes','Adidas', 'Hightop', '49.99', '11', '10', 'temp15');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, imageSource)
VALUES ('1017', 'YELLOW SHOES', 'Yellow Shoes','Adidas', 'Hightop', '49.99', '11', '10', 'temp16');

INSERT INTO shoes(type, product_id)
VALUES(2,'1014');
INSERT INTO shoes(type, product_id)
VALUES(2,'1015');
INSERT INTO shoes(type, product_id)
VALUES(2,'1016');
INSERT INTO shoes(type, product_id)
VALUES(2,'1017');


INSERT INTO "user"(user_id)
VALUES ('0001');

INSERT INTO "user"(user_id)
VALUES ('0002');

INSERT INTO "user"(user_id)
VALUES ('0003');

INSERT INTO "user"(user_id)
VALUES ('0004');

INSERT INTO "user"(user_id)
VALUES ('0005');

INSERT INTO "user"(user_id)
VALUES ('0006');

INSERT INTO customer(address, city, state, customer_id, date_account_created, first_name, last_name, email, phone_number, user_id)
VALUES ('123 street', 'Minneapolis', 'MN', '0001', '4/9/2023','Justin', 'Pham', 'justin@email.com', '5555555555', '0002');

INSERT INTO customer(address, city, state, customer_id, date_account_created, first_name, last_name, email, phone_number, user_id)
VALUES ('123 street', 'Saint Paul', 'MN', '0002', '4/9/2023','Tom', 'Waterman', 'Tom@email.com', '5555555555', '0003'); 

INSERT INTO customer(address, city, state, customer_id, date_account_created, first_name, last_name, email, phone_number, user_id)
VALUES ('124 street', 'Minneapolis', 'MN', '0003', '4/9/2023','Dylan', 'Skokan', 'Dylan@email.com', '5555555555', '0004'); 

INSERT INTO customer(address, city, state, customer_id, date_account_created, first_name, last_name, email, phone_number, user_id)
VALUES ('124 street', 'Saint Paul', 'MN', '0004', '4/9/2023','Isaiah', 'Cuellar', 'Isaiah@email.com', '5555555555', '0001'); 

INSERT INTO customer(address, city, state, customer_id, date_account_created, first_name, last_name, email, phone_number, user_id)
VALUES ('125 street', 'Minneapolis', 'MN', '0005', '4/9/2023','Kyle', 'McClernon', 'Isaiah@email.com', '5555555555', '0006') ;