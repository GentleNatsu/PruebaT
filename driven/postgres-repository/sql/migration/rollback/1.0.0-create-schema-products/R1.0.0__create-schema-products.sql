
-- ==========================
-- Eliminar tabla order_lines
-- ==========================
DROP TABLE IF EXISTS order_lines;

-- ==========================
-- Eliminar tabla orders
-- ==========================
DROP TABLE IF EXISTS orders;

-- ==========================
-- Eliminar tabla products
-- ==========================
DROP TABLE IF EXISTS products;


DELETE FROM flyway_schema_history WHERE version = '1.0.0';
