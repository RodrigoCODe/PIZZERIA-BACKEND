
delete from pizzas_por_pedido;
delete from pedidos;
delete from clientes;
delete from barrios;
delete from pizzas;

alter SEQUENCE seq_pedidos restart with 1;
alter SEQUENCE seq_clientes restart with 1;
alter SEQUENCE seq_barrios restart with 1;
alter SEQUENCE seq_pizzas restart with 1;

INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'Nueva Italia');
INSERT INTO clientes VALUES (NEXTVAL('seq_clientes'), 'San Juan 570','37492933', 'Federico',1);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Muzzarella', 250.0, 30);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Comun', 100.0, 30);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Napolitana', 300.0, 45);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Con Champignones Salteados', 250.0, 30);

INSERT INTO pedidos VALUES(nextval('seq_pedidos'),'08/11/2019 19:30',1,1);
INSERT INTO pedidos VALUES(nextval('seq_pedidos'),'08/11/2019 21:35',2,1);
INSERT INTO pedidos VALUES(nextval('seq_pedidos'),'08/11/2019 23:55',3,1);

INSERT INTO pizzas_por_pedido VALUES(1,1);
INSERT INTO pizzas_por_pedido VALUES(1,2);
INSERT INTO pizzas_por_pedido VALUES(2,3);
INSERT INTO pizzas_por_pedido VALUES(2,4);
INSERT INTO pizzas_por_pedido VALUES(3,1);