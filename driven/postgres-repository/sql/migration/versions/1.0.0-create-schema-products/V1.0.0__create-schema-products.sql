create table products (
   product_id bigserial not null,
   name varchar(100) not null,
   description text null,
   price numeric(10,2) not null,
   stock int null,
   created_at timestamp with time zone null,
   constraint pk_products primary key (product_id)
);

-- tabla: orders
create table orders (
  order_id bigserial not null,
  customer_name varchar(100) not null,
  customer_email varchar(150) null,
  order_date timestamp with time zone null,
  status varchar(20) null,
  total numeric(10,2) null,
  constraint pk_orders primary key (order_id)
);

-- tabla: order_lines
create table order_lines (
  line_id bigserial not null,
  order_id bigint not null,
  product_id bigint not null,
  quantity int not null,
  unit_price numeric(10,2) not null,
  constraint pk_order_lines primary key (line_id),
  constraint fk_order_lines_order foreign key (order_id)
    references orders(order_id)
    on delete cascade,
  constraint fk_order_lines_product foreign key (product_id)
    references products(product_id)
);
