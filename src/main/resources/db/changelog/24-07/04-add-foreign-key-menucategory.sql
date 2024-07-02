ALTER TABLE menu_item
ADD category_id INT NOT NULL;

ALTER TABLE menu_item
ADD FOREIGN KEY (category_id) REFERENCES menu_category(id);