CREATE TABLE clients (
                         id         bigserial PRIMARY KEY,
                         first_name varchar(100) NOT NULL,
                         last_name  varchar(100) NOT NULL,
                         age        int NOT NULL
);

CREATE TABLE administrators (
                                id    bigserial PRIMARY KEY,
                                name  varchar(100) NOT NULL,
                                email varchar(150) NOT NULL UNIQUE
);

CREATE TABLE products (
                          id          bigserial PRIMARY KEY,
                          title       varchar(255) NOT NULL,
                          description varchar(1000),
                          price       numeric(12, 2) NOT NULL,
                          stock       int NOT NULL DEFAULT 0
);

CREATE TABLE orders (
                        id          bigserial PRIMARY KEY,
                        client_id   bigint NOT NULL,
                        total_price numeric(12, 2) NOT NULL,
                        paid        boolean NOT NULL DEFAULT false,
                        created_at  timestamp NOT NULL DEFAULT now()
);

CREATE TABLE order_products (
                                order_id   bigint NOT NULL,
                                product_id bigint NOT NULL,
                                PRIMARY KEY (order_id, product_id)
);

CREATE TABLE blacklist (
                           id        bigserial PRIMARY KEY,
                           client_id bigint NOT NULL,
                           admin_id  bigint NOT NULL,
                           reason    varchar(500) NOT NULL,
                           added_at  timestamp NOT NULL DEFAULT now()
);

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_client
        FOREIGN KEY (client_id) REFERENCES clients(id);

ALTER TABLE order_products
    ADD CONSTRAINT fk_order_products_order
        FOREIGN KEY (order_id) REFERENCES orders(id);

ALTER TABLE order_products
    ADD CONSTRAINT fk_order_products_product
        FOREIGN KEY (product_id) REFERENCES products(id);

ALTER TABLE blacklist
    ADD CONSTRAINT fk_blacklist_client
        FOREIGN KEY (client_id) REFERENCES clients(id);

ALTER TABLE blacklist
    ADD CONSTRAINT fk_blacklist_admin
        FOREIGN KEY (admin_id) REFERENCES administrators(id);