INSERT INTO USERS (EMAIL, NAME, PASSWORD)
VALUES ('user1@gmail.com', 'User1', '{noop}password1'),
       ('user2@gmail.com', 'User2', '{noop}password2'),
       ('user3@gmail.com', 'User3', '{noop}password3'),
       ('admin@gmail.com', 'Admin', '{noop}admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 4),
       ('USER', 2);

INSERT INTO RESTAURANTS (NAME)
VALUES ('Печки-лавочки'),
       ('Суши-терра'),
       ('Дрова-мука');

INSERT INTO POSITIONS_IN_MENU (DATE, DESCRIPTION, POSITION_TYPE, PRICE, RESTAURANT_ID)
VALUES ('2022-01-01', 'Винегрет', 'LUNCH', 150, 1),
       ('2022-01-01', 'Борщ', 'LUNCH', 200,  1),
       ('2022-01-01', 'Картофельное пюре', 'LUNCH', 130, 1),
       ('2022-01-01', 'Котлета по Киевски', 'LUNCH', 190, 1),
       ('2022-01-01', 'Компот', 'LUNCH', 30, 1),

       ('2022-01-01', 'Цезарь', 'LUNCH', 250, 2),
       ('2022-01-01', 'Щи со свежей капустой', 'LUNCH', 170, 2),
       ('2022-01-01', 'Рис', 'LUNCH', 120, 2),
       ('2022-01-01', 'Бефстроганов', 'LUNCH', 250, 2),
       ('2022-01-01', 'Морс', 'LUNCH', 35, 2),

       ('2022-01-01', 'Гнездо глухаря', 'LUNCH', 200, 3),
       ('2022-01-01', 'Харчо', 'LUNCH', 200, 3),
       ('2022-01-01', 'Гречневая каша', 'LUNCH', 180, 3),
       ('2022-01-01', 'Куриные отбивные', 'LUNCH', 270, 3),
       ('2022-01-01', 'Компот', 'LUNCH', 30, 3),

       ('2022-01-02', 'Сельдь под шубой', 'LUNCH', 200, 1),
       ('2022-01-02', 'Борщ', 'LUNCH', 190, 1),
       ('2022-01-02', 'Картофельное пюре', 'LUNCH', 170, 1),
       ('2022-01-02', 'Шашлык из курицы', 'LUNCH', 300, 1),
       ('2022-01-02', 'Компот', 'LUNCH', 35, 1),

       ('2022-01-02', 'Цезарь', 'LUNCH', 250, 2),
       ('2022-01-02', 'Щи со свежей капустой', 'LUNCH', 170, 2),
       ('2022-01-02', 'Рис', 'LUNCH', 120, 2),
       ('2022-01-02', 'Бефстроганов', 'LUNCH', 250, 2),
       ('2022-01-02', 'Морс', 'LUNCH', 35, 2),

       ('2022-01-02', 'Гнездо глухаря', 'LUNCH', 200, 3),
       ('2022-01-02', 'Харчо', 'LUNCH', 200, 3),
       ('2022-01-02', 'Гречневая каша', 'LUNCH', 120, 3),
       ('2022-01-02', 'Шашлык из свинины', 'LUNCH', 350, 3),
       ('2022-01-02', 'Компот', 'LUNCH', 30, 3)
      ;

INSERT INTO VOTES (DATE, USER_ID, RESTAURANT_ID)
VALUES ('2022-01-01', 1, 1),
       ('2022-01-01', 2, 2),
       ('2022-01-01', 3, 2),

       ('2022-01-02', 1, 1),
       ('2022-01-01', 2, 1),
       ('2022-01-01', 3, 3)
       ;



