create table menu_category
(
    id            int auto_increment
        primary key,
    category_name varchar(120) not null,
    constraint category_name_UNIQUE
        unique (category_name),
    constraint id_UNIQUE
        unique (id)
);

INSERT INTO paprica.menu_category (id, category_name) VALUES (1, 'Летний сезон');
INSERT INTO paprica.menu_category (id, category_name) VALUES (2, 'Горячее');
INSERT INTO paprica.menu_category (id, category_name) VALUES (3, 'Мангал');
INSERT INTO paprica.menu_category (id, category_name) VALUES (4, 'Салаты');
INSERT INTO paprica.menu_category (id, category_name) VALUES (5, 'Супы');