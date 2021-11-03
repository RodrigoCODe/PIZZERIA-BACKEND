delete from pizzas_por_pedido;
delete from pedidos;
delete from clientes;
delete from barrios;

alter SEQUENCE seq_pizzas restart with 1;
alter SEQUENCE seq_pedidos restart with 1;
alter SEQUENCE seq_clientes restart with 1;
alter SEQUENCE seq_barrios restart with 1;

INSERT INTO barrios VALUES(nextval('seq_barrios'),'Altos de Chilecito');
INSERT INTO clientes VALUES (nextval('seq_clientes'), 'Siempre viva', '12312312', 'Jose', 1);
INSERT INTO clientes VALUES (nextval('seq_clientes'), 'Albornoz', '38440761', 'Eduardo', 1);
