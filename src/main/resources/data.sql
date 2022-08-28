INSERT INTO USERS (EMAIL, NAME, PASSWORD)
VALUES ('user@gmail.com', 'User', 'password'),
       ('admin@javaops.ru', 'Admin', 'admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('ROLE_USER', 1),
       ('ROLE_ADMIN', 2),
       ('ROLE_USER', 2);

INSERT INTO RESTAURANTS (NAME)
VALUES ('Печки-лавочки'),
       ('Суши-терра'),
       ('Дрова');