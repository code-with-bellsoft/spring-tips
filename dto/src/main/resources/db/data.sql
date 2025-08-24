INSERT INTO customers (id, name, email, password, status) VALUES (1, 'John Doe', 'john.doe@gmail.com', 'johnpass1', 'BRONZE');
INSERT INTO customers (id, name, email, password, status) VALUES (2, 'Lily Smith', 'lily.smith@gmail.com', 'lilypass1', 'SILVER');

INSERT INTO orders (id, customer_id, total_price) VALUES (1, 1, 567.7);
INSERT INTO orders (id, customer_id, total_price) VALUES (2, 1, 22.5);
INSERT INTO orders (id, customer_id, total_price) VALUES (3, 2, 400.0);

INSERT INTO employee (id, name, email, password) VALUES (1, 'Michael Black', 'mick.black@gmail.com', 'mickpass1');
INSERT INTO employee (id, name, email, password) VALUES (2, 'Caroline Lee', 'caroline@gmail.com', 'leepass1');

INSERT INTO users (id, user_name, email, password) VALUES (1, 'big_bad_wolf', 'jake.sommers@gmail.com', 'jakepass1');
INSERT INTO users (id, user_name, email, password) VALUES (2, 'drama_queen', 'lucy.white@gmail.com', 'lucypass1');

INSERT INTO dog (id, name, age) VALUES (1, 'Sparks', 2);

INSERT INTO cat (id, name, age) VALUES (1, 'Mr Whiskers', 3);

INSERT INTO address (id, country, city, zip) VALUES (1, 'Germany', 'Dresden', '12345RD');
INSERT INTO manufacturer (id, name, license, address_id) VALUES (1, 'SynthForge', 'WRV-1234', 1);
INSERT INTO supplier (id, name) VALUES (1, 'Bumblebeeline');
INSERT INTO device(id, model, manufacturer_id, serial_number, lot_number, supplier_id) VALUES (1, 'X-300', 1, 'FR986756GR', 12, 1);

INSERT INTO student (id, name, email, password) VALUES (1, 'Jimmy White', 'jim.whitek@gmail.com', 'jimpass1');