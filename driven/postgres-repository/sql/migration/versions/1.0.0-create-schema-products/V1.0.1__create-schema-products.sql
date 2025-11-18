INSERT INTO products (product_id, name, description, price, stock, created_at) VALUES
  (1, 'Laptop Pro 15', 'Portátil de alto rendimiento para profesionales.', 1499.99, 10, NOW()),
  (2, 'Auriculares Inalámbricos X2', 'Cancelación activa de ruido y batería de larga duración.', 199.90, 50, NOW()),
  (3, 'Teclado Mecánico RGB', 'Teclado mecánico con switches rojos.', 89.99, 30, NOW()),
  (4, 'Monitor UltraWide 34"', 'Monitor panorámico ideal para multitarea.', 499.50, 20, NOW()),
  (5, 'Ratón Gamer GX', 'Ratón ergonómico con 8 botones programables.', 59.90, 45, NOW());

INSERT INTO orders (order_id, customer_name, customer_email, order_date, status, total) VALUES
  (1, 'Carlos Fernandez', 'carlos.fernandez@example.com', NOW(), 'PAID', 1789.89),
  (2, 'Laura Gómez', 'laura.gomez@example.com', NOW(), 'PENDING', 289.89),
  (3, 'Ana Torres', 'ana.torres@example.com', NOW(), 'SHIPPED', 559.40);

-- Pedido 1 (Carlos Fernandez)
INSERT INTO order_lines (line_id, order_id, product_id, quantity, unit_price) VALUES
   (1, 1, 1, 1, 1499.99),   -- Laptop Pro 15
   (2, 1, 2, 1, 199.90),    -- Auriculares X2
   (3, 1, 5, 1, 59.00);     -- Ratón Gamer GX

-- Pedido 2 (Laura Gómez)
INSERT INTO order_lines (line_id, order_id, product_id, quantity, unit_price) VALUES
   (4, 2, 3, 1, 89.99),     -- Teclado Mecánico
   (5, 2, 5, 2, 59.95);     -- Ratón Gamer GX

-- Pedido 3 (Ana Torres)
INSERT INTO order_lines (line_id, order_id, product_id, quantity, unit_price) VALUES
   (6, 3, 4, 1, 499.50),    -- Monitor UltraWide
   (7, 3, 2, 1, 59.90);     -- Auriculares X2
