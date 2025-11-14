-- ==========================
-- Tabla: products
-- ==========================
CREATE TABLE products (
    product_id BIGSERIAL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price NUMERIC(10,2) NOT NULL,
    stock INT,
    created_at timestamp with time zone,

    PRIMARY KEY (product_id)
);

-- ==========================
-- Tabla: orders
-- ==========================
CREATE TABLE orders (
    order_id BIGSERIAL,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(150),
    order_date timestamp with time zone,
    status VARCHAR(20),
    total NUMERIC(10,2),

    PRIMARY KEY (order_id)
);

-- ==========================
-- Tabla: order_lines
-- ==========================
CREATE TABLE order_lines (
    line_id BIGSERIAL,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    unit_price NUMERIC(10,2) NOT NULL,

    PRIMARY KEY (line_id),
    FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
        ON DELETE CASCADE,
    FOREIGN KEY (product_id)
        REFERENCES products(product_id)
);
