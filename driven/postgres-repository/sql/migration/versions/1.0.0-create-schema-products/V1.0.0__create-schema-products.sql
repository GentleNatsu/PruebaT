-- public.products definition

-- Drop table

-- DROP TABLE public.products;

CREATE table public.products (
	price float4 NULL,
	product_id int8 NOT NULL,
	"name" varchar(255) NULL,
	"section" varchar(255) NULL,
	CONSTRAINT products_pkey PRIMARY KEY (product_id)
);


-- public.stores definition

-- Drop table

-- DROP TABLE public.stores;

CREATE TABLE public.stores (
	store_id bigserial NOT NULL,
	address varchar(255) NULL,
	description varchar(255) NULL,
	CONSTRAINT stores_pkey PRIMARY KEY (store_id)
);


-- public.racks definition

-- Drop table

-- DROP TABLE public.racks;

CREATE TABLE public.racks (
	capacity int4 NULL,
	rack_id int8 NOT NULL,
	store_id int8 NULL,
	"section" varchar(255) NULL,
	CONSTRAINT racks_pkey PRIMARY KEY (rack_id),
	CONSTRAINT fkew7m6yup8tg2v1vwv07m1di5y FOREIGN KEY (store_id) REFERENCES public.stores(store_id)
);


-- public.stock_rack definition

-- Drop table

-- DROP TABLE public.stock_rack;

CREATE TABLE public.stock_rack (
	quantity int4 NULL,
	product_id int8 NOT NULL,
	rack_id int8 NOT NULL,
	store_id int8 NOT NULL,
	CONSTRAINT stock_rack_pkey PRIMARY KEY (product_id, rack_id, store_id),
	CONSTRAINT fk3ge5dcdqqp540sskn5mlelndm FOREIGN KEY (rack_id) REFERENCES public.racks(rack_id),
	CONSTRAINT fk8fdx7lfnaot3c7xjy6fw25bdr FOREIGN KEY (store_id) REFERENCES public.stores(store_id),
	CONSTRAINT fkiscarop6jhg9du8tbvyi2xtey FOREIGN KEY (product_id) REFERENCES public.products(product_id)
);


-- public.warehouse_zone definition

-- Drop table

-- DROP TABLE public.warehouse_zone;

CREATE TABLE public.warehouse_zone (
	capacity int4 NULL,
	store_id int8 NULL,
	warehouse_id bigserial NOT NULL,
	description varchar(255) NULL,
	CONSTRAINT warehouse_zone_pkey PRIMARY KEY (warehouse_id),
	CONSTRAINT fk5yt143dbeqep3x9kdl1lrtf7x FOREIGN KEY (store_id) REFERENCES public.stores(store_id)
);


-- public.stock_warehouse definition

-- Drop table

-- DROP TABLE public.stock_warehouse;

CREATE TABLE public.stock_warehouse (
	quantity int4 NULL,
	product_id int8 NOT NULL,
	store_id int8 NOT NULL,
	warehouse_id int8 NOT NULL,
	CONSTRAINT stock_warehouse_pkey PRIMARY KEY (product_id, store_id, warehouse_id),
	CONSTRAINT fk1stiqwgahjh2upg7sg1cw3789 FOREIGN KEY (warehouse_id) REFERENCES public.warehouse_zone(warehouse_id),
	CONSTRAINT fk69s2njrwmciv65wr0xxe1e5m8 FOREIGN KEY (store_id) REFERENCES public.stores(store_id),
	CONSTRAINT fkigryw6miwtvivnb93g7nqjqcc FOREIGN KEY (product_id) REFERENCES public.products(product_id)
);


-- public.revinfo definition

-- Drop table

-- DROP TABLE public.revinfo;

CREATE TABLE public.revinfo (
	rev int4 NOT NULL,
	revtstmp int8 NULL,
	CONSTRAINT revinfo_pkey PRIMARY KEY (rev)
);

-- public.revinfo_seq definition

-- DROP SEQUENCE public.revinfo_seq;

CREATE SEQUENCE public.revinfo_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- public.stores_h definition

-- Drop table

-- DROP TABLE public.stores_h;

CREATE TABLE public.stores_h (
	store_id int8 NOT NULL,
	rev int4 NOT NULL,
	revtype int2 NULL,
	address varchar(255) NULL,
	description varchar(255) NULL,
	CONSTRAINT stores_h_pkey PRIMARY KEY (rev, store_id),
	CONSTRAINT fkoxvqian1g7as3bu0ktgto890n FOREIGN KEY (rev) REFERENCES public.revinfo(rev)
);


INSERT INTO products(product_id, name, price, "section") VALUES(1,'Arroz de Valencia', 6.5,null);
INSERT INTO products(product_id, name, price, "section") VALUES(2,'Galletas sin gluten', 3.6,1);
INSERT INTO products(product_id, name, price, "section") VALUES(3,'Leche de vaca', 1.5,2);
INSERT INTO products(product_id, name, price, "section") VALUES(4,'Café soluble',4.0,3);
INSERT INTO products(product_id, name, price, "section") VALUES(5,'Aceite de oliva virgen extra', 8.0,null);
INSERT INTO products(product_id, name, price, "section") VALUES(6,'Yogur natural', 1.5,null);
INSERT INTO products(product_id, name, price, "section") VALUES(7, 'Pack Agua 6 ',6.0,null);
INSERT INTO products(product_id, name, price, "section") VALUES(8,'Zumo de naranja natural', 3.0,null);
INSERT INTO products(product_id, name, price, "section") VALUES(9,'Helado chocolate y vainilla', 3.2,1);
INSERT INTO products(product_id, name, price, "section")VALUES(10,'Mochis pistacho', 3.5,null);


INSERT INTO public.stores (address, description) VALUES('Tienda Calle Alquerias', 'tienda');
INSERT INTO public.stores (address, description) VALUES('Tienda Casa de Javier Merce', 'Peor tienda');
INSERT INTO public.stores (address, description) VALUES('Tienda Casa de Mi casa', 'Mejor tienda');

INSERT INTO public.racks (capacity, rack_id, store_id, "section") VALUES(40, 1, 1, '1');
INSERT INTO public.racks (capacity, rack_id, store_id, "section") VALUES(15, 2, 1, '2');
INSERT INTO public.racks (capacity, rack_id, store_id, "section") VALUES(12, 3, 1, '3');
INSERT INTO public.racks (capacity, rack_id, store_id, "section") VALUES(1000, 4, 1, null);

INSERT INTO public.stock_rack (quantity, product_id, rack_id, store_id) VALUES(4, 3, 2, 1);
INSERT INTO public.stock_rack (quantity, product_id, rack_id, store_id) VALUES(5, 4, 3, 1);

INSERT INTO public.warehouse_zone (capacity, store_id, description) VALUES(50, 1, 'Zona de almacenaje CREADA AL EMPEZAR');


INSERT INTO public.stock_warehouse (quantity, product_id, store_id, warehouse_id) VALUES(12, 1, 1, 1);
INSERT INTO public.stock_warehouse (quantity, product_id, store_id, warehouse_id) VALUES(12, 2, 1, 1);
INSERT INTO public.stock_warehouse (quantity, product_id, store_id, warehouse_id) VALUES(12, 5, 1, 1);
INSERT INTO public.stock_warehouse (quantity, product_id, store_id, warehouse_id) VALUES(12, 7, 1, 1);






