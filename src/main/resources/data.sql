INSERT INTO USERS (EMAIL, NAME, PASSWORD)
VALUES ('user1@gmail.com', 'User1', '{noop}password1'),
       ('user2@gmail.com', 'User2', '{noop}password2'),
       ('user3@gmail.com', 'User3', '{noop}password3'),
       ('admin@gmail.com', 'Admin', '{noop}admin'),
       ('guest@gmail.com', 'Guest', '{noop}guest');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('USER', 2),
       ('USER', 3),
       ('ADMIN', 4),
       ('USER', 4);

INSERT INTO RESTAURANTS (NAME)
VALUES ('Печки-лавочки'),
       ('Суши-терра'),
       ('Дрова-мука');

INSERT INTO MENU_ITEM (DATE_MENU_ITEM, DESCRIPTION, PRICE, RESTAURANT_ID)
VALUES ('2022-01-01', 'Винегрет', 150, 1),
       ('2022-01-01', 'Борщ', 200,  1),
       ('2022-01-01', 'Картофельное пюре', 130, 1),
       ('2022-01-01', 'Котлета по Киевски', 190, 1),
       ('2022-01-01', 'Компот', 30, 1),

       ('2022-01-01', 'Цезарь', 250, 2),
       ('2022-01-01', 'Щи со свежей капустой', 170, 2),
       ('2022-01-01', 'Рис', 120, 2),
       ('2022-01-01', 'Бефстроганов', 250, 2),
       ('2022-01-01', 'Морс', 35, 2),

       ('2022-01-01', 'Гнездо глухаря', 200, 3),
       ('2022-01-01', 'Харчо', 200, 3),
       ('2022-01-01', 'Гречневая каша', 180, 3),
       ('2022-01-01', 'Куриные отбивные', 270, 3),
       ('2022-01-01', 'Компот', 30, 3),

       ('2022-01-02', 'Сельдь под шубой', 200, 1),
       ('2022-01-02', 'Борщ', 190, 1),
       ('2022-01-02', 'Картофельное пюре', 170, 1),
       ('2022-01-02', 'Шашлык из курицы', 300, 1),
       ('2022-01-02', 'Компот', 35, 1),

       ('2022-01-02', 'Цезарь', 250, 2),
       ('2022-01-02', 'Щи со свежей капустой', 170, 2),
       ('2022-01-02', 'Рис', 120, 2),
       ('2022-01-02', 'Бефстроганов', 250, 2),
       ('2022-01-02', 'Морс', 35, 2),

       ('2022-01-02', 'Гнездо глухаря', 200, 3),
       ('2022-01-02', 'Харчо', 200, 3),
       ('2022-01-02', 'Гречневая каша', 120, 3),
       ('2022-01-02', 'Шашлык из свинины', 350, 3),
       ('2022-01-02', 'Компот', 30, 3)
      ;

INSERT INTO VOTES (DATE_VOTE, USER_ID, RESTAURANT_ID)
VALUES ('2022-01-01', 1, 1),
       ('2022-01-01', 2, 2),
       ('2022-01-01', 3, 2),

       ('2022-01-02', 1, 1),
       ('2022-01-02', 2, 1),
       ('2022-01-02', 3, 3);



