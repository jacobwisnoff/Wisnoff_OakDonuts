-- Create MenuItem and Orders tables for Oak Donuts
CREATE TABLE MenuItem (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE Orders (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    menuitemid INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert 6 donut menu items for Oak Donuts
INSERT INTO MenuItem (id, name, price) VALUES (1, 'Glazed', 1.25);
INSERT INTO MenuItem (id, name, price) VALUES (2, 'Chocolate Frosted', 1.50);
INSERT INTO MenuItem (id, name, price) VALUES (3, 'Boston Creme', 1.75);
INSERT INTO MenuItem (id, name, price) VALUES (4, 'Jelly Filled', 1.60);
INSERT INTO MenuItem (id, name, price) VALUES (5, 'Maple Bacon', 2.25);
INSERT INTO MenuItem (id, name, price) VALUES (6, 'Sprinkles', 1.40);

