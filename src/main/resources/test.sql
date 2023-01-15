CREATE SEQUENCE request_id_seq;

ALTER TABLE request
    ALTER COLUMN request_id
        SET DEFAULT NEXTVAL('request_id_seq');

CREATE SEQUENCE country_id_seq;

ALTER TABLE country
    ALTER COLUMN country_id
        SET DEFAULT NEXTVAL('country_id_seq');

CREATE SEQUENCE orders_id_seq;

ALTER TABLE orders
    ALTER COLUMN orders_id
        SET DEFAULT NEXTVAL('orders_id_seq');

INSERT INTO public.country(
	 country_name)
	VALUES ('Canada'), ('Ukraine'), ('USA');

INSERT INTO public.account(
  email, password, phone, description, country_fk, role_fk, name, surname, sex)
  VALUES
   ('admin@gmail.com', 'password', '+380506585669', 'Some information about person...', 1, 1, 'Victoria', 'Ponomarenko', false),
   ('test@gmail.com', 'test', '+380506585669', 'Some information about person...', 1, 2, 'Test', 'TestSurname', true),
   ('user1@gmail.com', 'user1', '+380506585669', 'Some information about person...', 2, 2, 'Name1', 'Surname1', false),
   ('user2@gmail.com', 'user2', '+380506858666', 'Some information about person...', 2, 2, 'Name2', 'Surname2', true),
   ('user3@gmail.com', 'user3', '+380608599325', 'Some information about person...', 1, 3, 'Name3', 'Surname3', false),
   ('user4@gmail.com', 'user4', '+380506585569', 'Some information about person...', 2, 3, 'Name4', 'Surname4', true),
   ('user5@gmail.com', 'user5', '+380508796669', 'Some information about person...', 1, 3, 'Name5', 'Surname5', true);

INSERT INTO public.orders(
	title_order, description_order, price, account_fk)
	VALUES
	('Test 1-1', 'Sescription of order - test 1-1', 250, 2),
	('Test 1-2', 'Sescription of order - test 1-2', 850, 2),
	('Test 1-3', 'Sescription of order - test 1-3', 960, 2),
	('Test 2-1', 'Sescription of order - test 2-1', 250, 3),
	('Test 2-2', 'Sescription of order - test 2-2', 852, 3),
	('Test 3', 'Sescription of order - test 3', 1250, 3);

INSERT INTO public.request(
	account_fk, order_fk, request_description)
	VALUES
	(5, 1, 'Test 1-1'),
	(6, 1, 'Test 1-2')
	(7, 1, 'Test 1-3')
	(5, 2, 'Test 2-1');

	INSERT INTO public.role(
	role_id, role_name)
	VALUES
	(1, 'ADMIN'),
	(2, 'USER_CUSTOMER'),
	(3, 'USER_EXECUTOR');