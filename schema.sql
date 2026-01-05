CREATE TABLE vehicles (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR2(50),
    type VARCHAR2(30),
    available NUMBER(1)
);

CREATE TABLE rentals (
    rental_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    vehicle_id NUMBER,
    customer_name VARCHAR2(50),
    rent_date DATE,
    return_date DATE,
    CONSTRAINT fk_vehicle FOREIGN KEY (vehicle_id)
    REFERENCES vehicles(id)
);

INSERT INTO vehicles (name, type, available) VALUES ('Honda City', 'Car', 1);
INSERT INTO vehicles (name, type, available) VALUES ('Royal Enfield', 'Bike', 1);
INSERT INTO vehicles (name, type, available) VALUES ('Swift Dzire', 'Car', 1);
