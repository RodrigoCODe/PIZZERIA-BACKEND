
delete from pizzas_por_pedido;

delete from pedidos;
delete from pizzas;
delete from clientes;
delete from barrios;

alter sequence seq_pedidos restart with 1;
alter sequence seq_pizzas restart with 1;
alter sequence seq_barrios restart with 1;
alter sequence seq_clientes restart with 1;

insert into barrios values(nextval('seq_barrios'), 'San Francisco');

insert into clientes values(nextval('seq_clientes'), 'San Francisco', '28131367', 'Rodrigo Alarcon',1);

insert into pizzas values(nextval('seq_pizzas'), 'Napolitana', 250.0, 15);
insert into pizzas values(nextval('seq_pizzas'), 'Comun', 200.0, 10);
