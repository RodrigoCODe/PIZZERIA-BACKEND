TRUNCATE TABLE clientes CASCADE;
TRUNCATE TABLE pizzas CASCADE;
TRUNCATE TABLE barrios CASCADE;
TRUNCATE TABLE pedidos CASCADE;
TRUNCATE TABLE pizzas_por_pedido CASCADE;

ALTER SEQUENCE seq_barrios RESTART WITH 1;
ALTER SEQUENCE seq_clientes RESTART WITH 1;
ALTER SEQUENCE seq_pedidos RESTART WITH 1;
ALTER SEQUENCE seq_pizzas RESTART WITH 1;

INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Comun', 150.0, 30);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Especial', 200.0, 30);

INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'Mayo');
INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'Paiman Sur');

INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'), 'San Juan 570','37492933', 'Manuel',1);
INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'), 'Santa Rosa 544','38222999', 'Federico',2);

INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),1,'15/11/2019 21:30',1);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),2,'18/11/2019 20:10',1);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),2,'18/11/2019 20:30',2);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),1,'19/11/2019 21:30',1);

INSERT INTO pizzas_por_pedido VALUES(1,2);
INSERT INTO pizzas_por_pedido VALUES(2,1);
INSERT INTO pizzas_por_pedido VALUES(3,1);
INSERT INTO pizzas_por_pedido VALUES(3,2);
INSERT INTO pizzas_por_pedido VALUES(4,1);