create table MenuItem
(
    id          int auto_increment
        primary key,
    title       varchar(120)  not null,
    description longtext      not null,
    price       decimal(5, 2) not null,
    constraint id_UNIQUE
        unique (id)
);

