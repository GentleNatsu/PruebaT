-- public.orders definition

-- Drop table

-- DROP TABLE public.orders;

CREATE TABLE public.orders (
	order_id bigserial NOT NULL,
	customer_name varchar(255) NOT NULL,
	customer_email varchar(255) NULL,
	order_date varchar(255) NULL,
	status varchar(255) NULL,
	total float4 NULL,
	address varchar(255) NULL,
	customer_id varchar(255) NULL,
	priority int4 NULL,
	store_id varchar(255) NULL,
	CONSTRAINT pk_orders PRIMARY KEY (order_id)
);


-- public.products definition

-- Drop table

-- DROP TABLE public.products;

CREATE TABLE public.products (
	product_id bigserial NOT NULL,
	"name" varchar(255) NOT NULL,
	description varchar(255) NULL,
	price float4 NOT NULL,
	stock int4 NULL,
	created_at timestamptz NULL,
	CONSTRAINT pk_products PRIMARY KEY (product_id)
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


-- public.usuarios definition

-- Drop table

-- DROP TABLE public.usuarios;

CREATE TABLE public.usuarios (
	username varchar(255) NOT NULL,
	"password" varchar(255) NULL,
	rol varchar(255) NULL DEFAULT USER,
	CONSTRAINT usuarios_pkey PRIMARY KEY (username)
);


-- public.order_lines definition

-- Drop table

-- DROP TABLE public.order_lines;

CREATE TABLE public.order_lines (
	line_id bigserial NOT NULL,
	order_id int8 NOT NULL,
	product_id bigserial NOT NULL,
	quantity int4 NOT NULL,
	unit_price float4 NOT NULL,
	CONSTRAINT pk_order_lines PRIMARY KEY (line_id),
	CONSTRAINT fk_order_lines_order FOREIGN KEY (order_id) REFERENCES public.orders(order_id) ON DELETE CASCADE,
	CONSTRAINT fk_order_lines_product FOREIGN KEY (product_id) REFERENCES public.products(product_id)
);


-- public.store_products definition

-- Drop table

-- DROP TABLE public.store_products;

CREATE TABLE public.store_products (
	product_id bigserial NOT NULL,
	store_id bigserial NOT NULL,
	quantity int4 NULL,
	CONSTRAINT store_products_pkey PRIMARY KEY (product_id, store_id),
	CONSTRAINT fk_store_products_product FOREIGN KEY (product_id) REFERENCES public.products(product_id),
	CONSTRAINT fk_store_products_store FOREIGN KEY (store_id) REFERENCES public.stores(store_id)
);


-- public.vehicles definition

-- Drop table

-- DROP TABLE public.vehicles;

CREATE TABLE public.vehicles (
	vehicle_id bigserial NOT NULL,
	capacity int4 NULL,
	store_id bigserial NOT NULL,
	"type" varchar(255) NULL,
	CONSTRAINT vehicles_pkey PRIMARY KEY (vehicle_id),
	CONSTRAINT fk_vehicles_store FOREIGN KEY (store_id) REFERENCES public.stores(store_id)
);