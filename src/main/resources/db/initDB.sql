
DROP TABLE IF EXISTS shop;
DROP TABLE IF EXISTS goods;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE shop
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  addres     VARCHAR NOT NULL
);

CREATE TABLE goods (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  id_shop     INT NOT NULL,
  name        VARCHAR NOT NULL,
  FOREIGN KEY (id_shop) REFERENCES shop (id) ON DELETE CASCADE
);
