-- Crear la tabla 'proveedor'
CREATE TABLE proveedor (
                           id SERIAL PRIMARY KEY,
                           nombre VARCHAR(150) NOT NULL,
                           telefono VARCHAR(20),
                           correo VARCHAR(100),
                           activo BOOLEAN NOT NULL DEFAULT TRUE
);

-- Agregar la columna 'proveedor_id' a la tabla 'producto'
ALTER TABLE producto
    ADD COLUMN proveedor_id INTEGER;

-- Establecer la relación (llave foránea) entre producto y proveedor
ALTER TABLE producto
    ADD CONSTRAINT fk_producto_proveedor
        FOREIGN KEY (proveedor_id)
            REFERENCES proveedor(id);