INSERT INTO Suppliers (supplier_name)
VALUES ('ООО "Фрукты"');
INSERT INTO Suppliers (supplier_name)
VALUES ('ООО "Груши и яблоки"');
INSERT INTO Suppliers (supplier_name)
VALUES ('ООО "Овощебаза"');

INSERT INTO Fruits (fruit_name, fruit_type)
VALUES ('Карамелька', 'Яблоко');
INSERT INTO Fruits (fruit_name, fruit_type)
VALUES ('Черный принц', 'Яблоко');
INSERT INTO Fruits (fruit_name, fruit_type)
VALUES ('Зимняя', 'Груша');
INSERT INTO Fruits (fruit_name, fruit_type)
VALUES ('Нежность', 'Груша');

--цены, которые установил поставщик ООО "Фрукты" на июнь
--на яблоки "Карамелька"
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (1, 1, 10, '2024-06-01', '2024-06-15');
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (1, 1, 11, '2024-06-16', '2024-06-30');
--на яблоки "Черный принц"
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (1, 2, 9, '2024-06-01', '2024-06-10');
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (1, 2, 8, '2024-06-11', '2024-06-20');
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (1, 2, 7, '2024-06-21', '2024-06-30');
--на груши "Зимняя"
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (1, 3, 8, '2024-06-01', '2024-06-30');
--на груши "Нежность"
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (1, 4, 7, '2024-06-01', '2024-06-30');

--цены, которые установил поставщик ООО "Груши и яблоки" на июнь
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (2, 1, 9, '2024-06-01', '2024-06-30');
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (2, 2, 8, '2024-06-01', '2024-06-30');
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (2, 3, 2, '2024-06-01', '2024-06-30');
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (2, 4, 3, '2024-06-01', '2024-06-30');

--цены, которые установил поставщик ООО "Овощебаза" на июнь
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (3, 1, 2, '2024-06-01', '2024-06-30');
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (3, 2, 2, '2024-06-01', '2024-06-30');
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (3, 3, 2, '2024-06-01', '2024-06-30');
INSERT INTO Prices (supplier_id, fruit_id, price, start_date, end_date)
VALUES (3, 4, 2, '2024-06-01', '2024-06-30');