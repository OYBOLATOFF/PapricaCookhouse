create table menu_item_photo
(
    id      int auto_increment
        primary key,
    item_id int          not null,
    path    varchar(120) not null,
    constraint id_UNIQUE
        unique (id),
    constraint item_id
        foreign key (item_id) references menu_item (id)
);

create index item_id_idx
    on menu_item_photo (item_id);

