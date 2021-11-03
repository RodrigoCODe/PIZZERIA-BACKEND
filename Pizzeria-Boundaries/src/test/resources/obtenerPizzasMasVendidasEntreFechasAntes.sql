delete from pizzas_por_pedido;

delete from pedidos;
delete from pizzas;
delete from clientes;
delete from barrios;

alter sequence seq_pedidos restart with 1;
alter sequence seq_pizzas restart with 1;
alter sequence seq_barrios restart with 1;
alter sequence seq_clientes restart with 1;

insert into barrios values(1, 'San Francisco');
insert into barrios values(2, 'Centro');

insert into clientes values(1, 'San Francisco', '28131367', 'Rodrigo Alarcon',1);
insert into clientes values(2, '9 de Julio 123', '28123123', 'Juan Perez', 2);

insert into pizzas values(1, 'Napolitana', 250.0, 15);
insert into pizzas values(2, 'Comun', 200.0, 10);
insert into pizzas values(3, 'DobleMuzza', 250.0, 15);
insert into pizzas values(4, 'Especial', 270.0, 15);




insert into pedidos values(1,'2019-11-08 20:10:25-07',1, 1 );

insert into pedidos values(2,'2019-11-10 21:15:25-07', 2, 2);

insert into pizzas_por_pedido values (1, 1);
insert into pizzas_por_pedido values (1, 2);
insert into pizzas_por_pedido values (1, 1);
insert into pizzas_por_pedido values (1, 3);
insert into pizzas_por_pedido values (2, 1);
insert into pizzas_por_pedido values (2, 4);
insert into pizzas_por_pedido values (2, 2);
insert into pizzas_por_pedido values (2, 1);
insert into pizzas_por_pedido values (1, 2);
insert into pizzas_por_pedido values (2, 2);