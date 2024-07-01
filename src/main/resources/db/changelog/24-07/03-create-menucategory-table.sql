create table MenuCategory
(
    id            int auto_increment
        primary key,
    category_name varchar(120) not null,
    constraint category_name_UNIQUE
        unique (category_name),
    constraint id_UNIQUE
        unique (id)
);

