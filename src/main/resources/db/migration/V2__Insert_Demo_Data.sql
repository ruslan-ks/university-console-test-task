INSERT INTO lectors(name, degree, salary)
VALUES ('Godric Gryffindor', 'PROFESSOR', 1000), -- Gryffindor
       ('Minerva McGonagall', 'PROFESSOR', 800),
       ('Neville Longbottom', 'ASSISTANT', 20),
       ('Fat Friar', 'ASSOCIATE_PROFESSOR', 500), -- Hufflepuff
       ('Hengist of Woodcroft', 'PROFESSOR', 600),
       ('Percival Rackham', 'ASSISTANT', 10),
       ('Salazar Slytherin', 'PROFESSOR', 100500), -- Slytherin
       ('Severus Snape', 'PROFESSOR', 100500),
       ('Horace Slughorn', 'PROFESSOR', 100500),
       ('Tom Riddle', 'ASSISTANT', 100),
       ('Rowena Ravenclaw', 'PROFESSOR', 700); -- Ravenclaw

INSERT INTO departments(name, head_id)
VALUES ('Gryffindor', 1),
       ('Hufflepuff', 4),
       ('Slytherin', 7),
       ('Ravenclaw', 11);

INSERT INTO department_lectors(department_id, lector_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (3, 7),
       (3, 8),
       (3, 9),
       (3, 10),
       (4, 11);
