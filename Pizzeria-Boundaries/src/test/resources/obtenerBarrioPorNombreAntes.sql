
delete from pizzas_por_pedido;
delete from pedidos;
delete from clientes;
delete from barrios;
delete from pizzas;

alter SEQUENCE seq_pedidos restart with 1;
alter SEQUENCE seq_clientes restart with 1;
alter SEQUENCE seq_barrios restart with 1;
alter SEQUENCE seq_pizzas restart with 1;
Insert into barrios values (nextval('seq_barrios'),'Siempre');
Insert into barrios values (nextval('seq_barrios'),'Viva');
