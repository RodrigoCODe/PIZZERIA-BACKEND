delete from pizzas_por_pedido;

delete from pedidos;
delete from pizzas;
delete from clientes;
delete from barrios;

alter sequence seq_pedidos restart with 1;
alter sequence seq_pizzas restart with 1;
alter sequence seq_barrios restart with 1;
alter sequence seq_clientes restart with 1;