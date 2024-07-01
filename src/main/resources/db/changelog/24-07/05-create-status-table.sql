create table status
(
    name               varchar(45)  not null
        primary key,
    handler_class_name varchar(120) null,
    constraint handler_class_name_UNIQUE
        unique (handler_class_name),
    constraint name_UNIQUE
        unique (name)
);


INSERT INTO paprica.status (name, handler_class_name) VALUES ('AUTHORIZED', 'AuthorizedHandler');
INSERT INTO paprica.status (name, handler_class_name) VALUES ('EDITING_ITEM', 'EditingItemHandler');
INSERT INTO paprica.status (name, handler_class_name) VALUES ('NOT_AUTHORIZED', 'NotAuthorizedHandler');
INSERT INTO paprica.status (name, handler_class_name) VALUES ('SELECTED_ITEM', 'SelectedItemHandler');
INSERT INTO paprica.status (name, handler_class_name) VALUES ('WATCHING_ITEM', 'WatchingItemHandler');
INSERT INTO paprica.status (name, handler_class_name) VALUES ('WATCHING_MENU', 'WatchingMenuHandler');
