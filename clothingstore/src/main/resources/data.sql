--------------------------------------------- Shirts ---------------------------------------------
INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES (1005, 'V-Neck 100% cotton slim fit tee', 'hanes','white', 'slim', '49.99', 'XL', '10', '/assets/img/shirt1.png');
INSERT INTO shirt(type, product_id)
VALUES(7, 1005);

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1004', '100% cotton tee', 'hanes', 'black', 'tshirt', '49.99', 'XL', '10', '/assets/img/shirt2.png');
INSERT INTO shirt(type, product_id)
VALUES(1,'1004');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1002', 'Dinosaur Bar-b-que shirt', 'Balenciaga','black', 'tshirt', '49.99', 'L', '10', '/assets/img/shirt3.png');
INSERT INTO shirt(type, product_id)
VALUES(1,'1002');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1003', 'Naruto Shirt', 'UTE','grey', 'tshirt', '49.99', 'XL', '10', '/assets/img/shirt4.png');
INSERT INTO shirt(type, product_id)
VALUES(1,'1003');


INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1032', 'Hawaiian shirt', 'UTE','multicolor', 'polo', '49.99', 'XL', '10', '/assets/img/shirt5.png');
INSERT INTO shirt(type, product_id)
VALUES(2,'1032');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1033', 'Akatsuki sweatshirt', 'UTE','multicolor', 'sweat', '49.99', 'XL', '10', '/assets/img/shirt6.png');
INSERT INTO shirt(type, product_id)
VALUES(5,'1033');



--------------------------------------------- Pants ---------------------------------------------
INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1006', 'Endura pants', 'Endura','black', 'slim', '49.99', '32W 30L', '10', '/assets/img/pants1.png');
INSERT INTO pants(type, product_id, beltloops, pockets, zipper)
VALUES(2,'1006', true, true, true);

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1007', 'Khakhi pants', 'Levis','tan', 'boot cut', '49.99', '32W 30L', '10', '/assets/img/pants2.png');
INSERT INTO pants(type, product_id, beltloops, pockets, zipper)
VALUES(3,'1007', true, true, true);

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1008', 'Fox pants', 'fox','black/brown', 'slim', '49.99', '32W 30L', '10', '/assets/img/pants3.png');
INSERT INTO pants(type, product_id, beltloops, pockets, zipper)
VALUES(2,'1008', true, true, true);

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1009', 'Pinstripe pants', 'Gucci','white', 'boot cut', '49.99', '32W 30L', '10', '/assets/img/pants4.png');
INSERT INTO pants(type, product_id, beltloops, pockets, zipper)
VALUES(2,'1009', true, true, true);

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1098', 'oarnge chinos', 'bonobos','orange', 'slim', '49.99', '32W 30L', '10', '/assets/img/pants5.png');
INSERT INTO pants(type, product_id, beltloops, pockets, zipper)
VALUES(2,'1098', true, true, true);

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1099', 'cargo pants', 'Dickies','black', 'boot cut', '49.99', '32W 30L', '10', '/assets/img/pants6.png');
INSERT INTO pants(type, product_id, beltloops, pockets, zipper)
VALUES(2,'1099', true, true, true);


--------------------------------------------- Hats ---------------------------------------------
INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1010', 'Yellowstone hat', 'Zumiez','grey/blackz', 'baseball', '49.99', 'large', '10', '/assets/img/hat1.png');
INSERT INTO hat(type, product_id)
VALUES(1,'1010');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1011', 'Black Bucket hat', 'Artisan','black', 'bucket', '49.99', 'large', '10', '/assets/img/hat2.png');
INSERT INTO hat(type, product_id)
VALUES(3,'1011');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1012', 'Trail Magik Hat', 'trail Magik','red', 'baseball', '49.99', 'large', '10', '/assets/img/hat3.png');
INSERT INTO hat(type, product_id)
VALUES(1,'1012');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1013', 'Lawn Rebel hat', 'New Era','Gray', 'baseball', '49.99', 'large', '10', '/assets/img/hat4.png');
INSERT INTO hat(type, product_id)
VALUES(2,'1013');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1213', 'The Boulevard hat', 'New Era','tan', 'baseball', '49.99', 'large', '10', '/assets/img/hat5.png');
INSERT INTO hat(type, product_id)
VALUES(1,'1213');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1214', 'American flag hat', 'New Era','FDE', 'baseball', '49.99', 'large', '10', '/assets/img/hat6.png');
INSERT INTO hat(type, product_id)
VALUES(1,'1214');

--------------------------------------------- Shoes ---------------------------------------------
INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1014', 'Red High Heels', 'Calvin Klein','red', 'heels', '49.99', '11', '10', '/assets/img/shoes1.png');
INSERT INTO shoes(type, product_id)
VALUES(2,'1014');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1015', 'Black running shoes', 'Nike','black/neon green', 'running', '49.99', '11', '10', '/assets/img/shoes2.png');
INSERT INTO shoes(type, product_id)
VALUES(1,'1015');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1016', 'brown slip on dress shoes', 'Nordstrom','slip on', 'Hightop', '49.99', '11', '10', '/assets/img/shoes3.png');
INSERT INTO shoes(type, product_id)
VALUES(2,'1016');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1017', 'Purple running shoes', 'New Balance','purple', 'sneakers', '49.99', '11', '10', '/assets/img/shoes4.png');
INSERT INTO shoes(type, product_id)
VALUES(1,'1017');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1019', 'Blue loafers', 'Coach','Blue', 'loafers', '49.99', '11', '10', '/assets/img/shoes5.png');
INSERT INTO shoes(type, product_id)
VALUES(3,'1019');

INSERT INTO product (product_id, description, brand, color, fit, price, size, stock, image_source)
VALUES ('1020', 'winter boots', 'Northwave','black', 'boots', '49.99', '11', '10', '/assets/img/shoes6.png');
INSERT INTO shoes(type, product_id)
VALUES(4,'1020');

---------------------------------------- users --------------------------------------------------
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

--------------------------------------------- customers ---------------------------------------------
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



truncate table product cascade

 truncate table "user" cascade