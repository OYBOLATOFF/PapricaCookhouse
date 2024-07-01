ALTER TABLE MenuItem
ADD category_id INT NOT NULL;

ALTER TABLE MenuItem
ADD FOREIGN KEY (category_id) REFERENCES MenuCategory(id);