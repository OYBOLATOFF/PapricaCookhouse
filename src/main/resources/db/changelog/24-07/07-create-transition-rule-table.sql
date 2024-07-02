create table transition_rule
(
    first_status  varchar(45) not null,
    second_status varchar(45) not null,
    primary key (first_status, second_status),
    constraint first_status_fk
        foreign key (first_status) references status (name),
    constraint second_status_fk
        foreign key (second_status) references status (name)
);

create index second_status_fk_idx
    on transition_rule (second_status);

INSERT INTO paprica.transition_rule (first_status, second_status) VALUES ('NOT_AUTHORIZED', 'AUTHORIZED');
INSERT INTO paprica.transition_rule (first_status, second_status) VALUES ('SELECTED_ITEM', 'EDITING_ITEM');
INSERT INTO paprica.transition_rule (first_status, second_status) VALUES ('WATCHING_MENU', 'SELECTED_ITEM');
INSERT INTO paprica.transition_rule (first_status, second_status) VALUES ('SELECTED_ITEM', 'WATCHING_ITEM');
INSERT INTO paprica.transition_rule (first_status, second_status) VALUES ('AUTHORIZED', 'WATCHING_MENU');
INSERT INTO paprica.transition_rule (first_status, second_status) VALUES ('EDITING_ITEM', 'WATCHING_MENU');
INSERT INTO paprica.transition_rule (first_status, second_status) VALUES ('SELECTED_ITEM', 'WATCHING_MENU');
INSERT INTO paprica.transition_rule (first_status, second_status) VALUES ('WATCHING_ITEM', 'WATCHING_MENU');