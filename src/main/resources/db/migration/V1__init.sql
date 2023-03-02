CREATE TABLE IF NOT EXISTS users(
    id SERIAL,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(250),
    role VARCHAR(50),
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS categoria (
    id serial,
    categoria VARCHAR (10),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS invernadero (
        id serial,
        invernadero VARCHAR (10),
        sede VARCHAR (10),
        PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS clientes (
        id serial,
        fullname VARCHAR (30),
        phone VARCHAR (15),
        address VARCHAR (55),
        PRIMARY KEY (id)

    );


CREATE TABLE IF NOT EXISTS mesa (
        id serial,
        mesa VARCHAR(10) NOT NULL,
        id_invernadero INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (id_invernadero) REFERENCES invernadero(id)
    );

CREATE TABLE IF NOT EXISTS productos (
        id serial,
        nombre VARCHAR (60),
        id_categoria INT NOT NULL,
        id_mesa INT NOT NULL,
        clima VARCHAR (12),
        precio DECIMAL(7,2),
        cantidad DECIMAL(7,2),
        PRIMARY KEY (id),
        FOREIGN KEY (id_categoria) REFERENCES categoria(id),
        FOREIGN KEY (id_mesa) REFERENCES mesa(id)
    );

CREATE TABLE IF NOT EXISTS orden (
        id serial,
        create_at TIMESTAMP NOT NULL,
        id_clientes INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (id_clientes) REFERENCES clientes(id)

     );

CREATE TABLE IF NOT EXISTS detalles (
        id serial,
        id_orden INT NOT NULL,
        id_productos INT NOT NULL,
        cantidad DECIMAL(7,2),
        PRIMARY KEY (id),
        FOREIGN KEY (id_orden) REFERENCES orden(id),
        FOREIGN KEY (id_productos) REFERENCES productos(id)
        --cantidad

      );


CREATE VIEW productos_view as
    select p.*,c.categoria categoria, i.invernadero invernadero, m.mesa mesa, i.sede sede
    from productos p JOIN categoria c
    ON p.id_categoria = c.id
    JOIN mesa m
    ON p.id_mesa = m.id
    JOIN invernadero i
    ON i.id = m.id_invernadero;

CREATE VIEW mesa_view as
    select m.*,i.invernadero invernadero
    from mesa m JOIN invernadero i
    ON m.id_invernadero = i.id;

CREATE VIEW orden_view as
    select o.*, c.fullname clientes
    from orden o join clientes c on c.id=o.id_clientes
    order by o.create_at DESC;

CREATE VIEW detalle_view as
    select d.*, p.nombre nombre, i.invernadero invernadero, m.mesa mesa
    from detalles d
    join productos p
    ON p.id=d.id_productos
    JOIN mesa m
    ON p.id_mesa = m.id
    JOIN invernadero i
    ON i.id = m.id_invernadero;
