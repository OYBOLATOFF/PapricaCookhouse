ALTER TABLE menu_item
ADD category_id INT NOT NULL;

ALTER TABLE menu_item
ADD FOREIGN KEY (category_id) REFERENCES menu_category(id);

INSERT INTO paprica.menu_item (id, title, description, price, category_id) VALUES (1, 'Брускетта с лососем', 'Классическая закуска со сливочно-сырным соусом', 570.00, 1);
INSERT INTO paprica.menu_item (id, title, description, price, category_id) VALUES (2, 'Крабовый фреш ролл с овощами', 'Свежий ролл в рисовой бумаге с начинкой из крабового микса', 790.00, 1);
INSERT INTO paprica.menu_item (id, title, description, price, category_id) VALUES (3, 'Кесадилья с креветками', 'шеничная лепешка с начинкой из тигровых креветок', 650.00, 1);
INSERT INTO paprica.menu_item (id, title, description, price, category_id) VALUES (4, 'Баклажаны по-алжирски', 'Хрустящие баклажаны фаршированные сочной мясной начинкой из баранины. Вес 130/20 г', 510.00, 1);