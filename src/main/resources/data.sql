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

INSERT INTO POSITIONS (DATE, DESCRIPTION, POSITION_TYPE, RESTAURANT_ID)
VALUES ('2022-01-01', 'Венегрет', 'LUNCH', 1),
       ('2022-01-01', 'Борщ', 'LUNCH', 1),
       ('2022-01-01', 'Компот', 'LUNCH', 1),
       ('2022-01-01', 'Шашлык из курицы', 'LUNCH', 2),
       ('2022-01-01', 'Сельдь под шубой', 'LUNCH', 2),
       ('2022-01-01', 'Шашлык из свинины', 'LUNCH', 3);

-- INSERT INTO POSITIONS (DATE, DESCRIPTION, RESTAURANT_ID)
-- VALUES ('2022-01-01', 'Венегрет', 1),
--        ('2022-01-01', 'Борщ', 1),
--        ('2022-01-01', 'Компот', 1),
--        ('2022-01-01', 'Шашлык из курицы', 2),
--        ('2022-01-01', 'Сельдь под шубой', 2),
--        ('2022-01-01', 'Шашлык из свинины', 3);