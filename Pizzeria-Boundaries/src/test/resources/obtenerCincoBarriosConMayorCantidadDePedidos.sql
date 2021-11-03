delete from pizzas_por_pedido;
delete from pedidos;
delete from clientes;
delete from barrios;
delete from pizzas;

alter SEQUENCE seq_pedidos restart with 1;
alter SEQUENCE seq_clientes restart with 1;
alter SEQUENCE seq_barrios restart with 1;
alter SEQUENCE seq_pizzas restart with 1;

INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'Castro y Bazan');
INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'Lomas de Zamora');
INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'Altos Chilecito');
INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'Mis Montañas');
INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'140 Lotes');

INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'),'La Plata','38.400.761','Mariano',1);
INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'),'La Plata','38.400.762','Yamil',2);
INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'),'Siempre Viva','38.400.763','Pablo',3);
INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'),'Siempre Viva','38.400.764','Javier',4);
INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'),'Siempre Viva','38.400.765','Jose',5);
INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'),'Siempre Viva','38.400.766','Manuel',1);

INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Margarita', 50.0, 30);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Primavera', 50.0, 30);

INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),1,'15/11/2019 18:30',1);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),2,'15/11/2019 18:45',2);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),3,'15/11/2019 18:55',3);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),4,'15/11/2019 19:10',4);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),5,'15/11/2019 19:30',5);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),6,'15/11/2019 19:50',6);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),3,'15/11/2019 20:00',7);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),1,'15/11/2019 20:10',8);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),2,'15/11/2019 20:30',9);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),1,'15/11/2019 20:45',10);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),5,'15/11/2019 22:30',11);

INSERT INTO pizzas_por_pedido VALUES(1,1);
INSERT INTO pizzas_por_pedido VALUES(1,2);
INSERT INTO pizzas_por_pedido VALUES(2,2);
INSERT INTO pizzas_por_pedido VALUES(3,2);
INSERT INTO pizzas_por_pedido VALUES(3,1);
INSERT INTO pizzas_por_pedido VALUES(4,1);
INSERT INTO pizzas_por_pedido VALUES(5,2);
INSERT INTO pizzas_por_pedido VALUES(6,1);
INSERT INTO pizzas_por_pedido VALUES(7,2);
INSERT INTO pizzas_por_pedido VALUES(8,1);
INSERT INTO pizzas_por_pedido VALUES(8,2);
INSERT INTO pizzas_por_pedido VALUES(9,1);
INSERT INTO pizzas_por_pedido VALUES(10,2);
INSERT INTO pizzas_por_pedido VALUES(11,1);