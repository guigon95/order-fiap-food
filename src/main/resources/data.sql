------------------------------ Products ----------------------------------
INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (39.60, '52d5f43a-849e-4dd1-a36c-f199658f2475', 'HAMBURGUER', 'Pão, queijo, hamburguer 160g, alface, tomate e cebola', '', 'X-SALADA', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (45.90, random_uuid(), 'HAMBURGUER', 'Pão, queijo, bacon, hamburguer 160g, alface, tomate e cebola', '', 'X-SALADA-BACON', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (39.60, random_uuid(), 'HAMBURGUER', 'Pão, queijo, bacon, hamburguer 160g', '', 'X-BACON', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (39.60, random_uuid(), 'HAMBURGUER', 'Pão, queijo, milho, hamburguer 160g', '', 'X-MILHO', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (40.60, random_uuid(), 'HAMBURGUER', 'Pão, queijo, tomate, hamburguer 200g', '', 'X-BURGUER', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (5.55, random_uuid(), 'ACCOMPANIMENT', 'bacon em fatias', '', 'BACON', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (8.65, random_uuid(), 'ACCOMPANIMENT', 'Batata frita P', '', 'Batata P', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (10.65, random_uuid(), 'ACCOMPANIMENT', 'Batata frita M', '', 'Batata M', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (14.65, random_uuid(), 'ACCOMPANIMENT', 'Batata frita G', '', 'Batata G', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (11.65, random_uuid(), 'ACCOMPANIMENT', 'Cebola frita M', '', 'Cebola M', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (18.65, random_uuid(), 'ACCOMPANIMENT', 'Batata frita M com  queijo cheddar e bacon', '',
        'Batata Frita Suprema', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (6.65, random_uuid(), 'DESSERT', 'Sorvete de casquinha da máquina', '', 'Sorvete', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (9.99, random_uuid(), 'DESSERT', 'Bolo de chocolate com sorvete', '', 'Bolo com Sorvete', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (5.99, random_uuid(), 'DRINK', 'Refrigerante de laranja', '', 'Fanta Laranja', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (5.99, random_uuid(), 'DRINK', 'Refrigerante de uva', '', 'Fanta uva', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (5.99, random_uuid(), 'DRINK', 'Refrigerante de cola', '', 'Coca-Cola', 'ACTIVE');

INSERT INTO product_entity (price, id, category, description, images, name, status)
VALUES (5.99, random_uuid(), 'DRINK', 'Refrigerante de limao', '', 'Soda', 'ACTIVE');


------------------------------ Orders ----------------------------------
INSERT INTO ORDER_ENTITY (created_at, id, client_id, order_status) values
    ( CURRENT_TIMESTAMP(), 1, 100, 'RECEIVED');

INSERT INTO ORDER_ENTITY (created_at, id, client_id, order_status) values
    ( CURRENT_TIMESTAMP(), 2, 100, 'RECEIVED');

INSERT INTO ITEM_ORDER_ENTITY (quantity, order_id, product_id)
VALUES (2, 1, '52d5f43a-849e-4dd1-a36c-f199658f2475')