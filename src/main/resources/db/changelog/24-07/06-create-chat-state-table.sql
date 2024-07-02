create table chat_state
(
    chat_id bigint      not null,
    status  varchar(45) not null,
    primary key (chat_id, status),
    constraint chat_id_UNIQUE
        unique (chat_id),
    constraint status_fk
        foreign key (status) references status (name)
);