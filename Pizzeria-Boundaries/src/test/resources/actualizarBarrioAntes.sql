delete from barrios;

alter SEQUENCE seq_barrios restart with 1;

INSERT INTO barrios VALUES(nextval('seq_barrios'),'Mis Montañas');
