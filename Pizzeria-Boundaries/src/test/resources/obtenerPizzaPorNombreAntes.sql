
delete from pizzas_por_pedido;
delete from pedidos;
delete from clientes;
delete from barrios;
delete from pizzas;

alter SEQUENCE seq_pedidos restart with 1;
alter SEQUENCE seq_clientes restart with 1;
alter SEQUENCE seq_barrios restart with 1;
alter SEQUENCE seq_pizzas restart with 1;

INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Margarita', 120, 30);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Mozzarella', 120.50, 30);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Margarita Picante', 120.50, 30);