DELETE FROM shop;
DELETE FROM goods;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO shop (name, addres)
VALUES ('Магазин N1', 'Москва 111');

INSERT INTO shop (name, addres)
VALUES ('Магазин N2', 'Москва 222');

INSERT INTO shop (name, addres)
VALUES ('Магазин N3', 'Москва 333');

INSERT INTO goods (name, id_shop) VALUES
  ('Комп 1', 100000),
  ('Комп 2', 100000),
  ('Комп 3', 100000),
  ('Моник 1', 100001),
  ('Моник 2', 100001),
  ('Моник 3', 100001);
