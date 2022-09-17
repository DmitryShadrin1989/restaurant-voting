# Voting system application
Diploma-graduation project

Design and implement a REST API using Hibernate/Spring/SpringMVC (Spring-Boot preferred!) **without frontend**.

The task is:

Build a voting system for deciding where to have lunch.

* 2 types of users: admin and regular users
* Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
* Menu changes each day (admins do the updates)
* Users can vote on which restaurant they want to have lunch at
* Only one vote counted per user
* If user votes again the same day:
    - If it is before 11:00 we assume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides a new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with API documentation and couple curl commands to test it (**better - link to Swagger**).

-----------------------------
P.S.: Make sure everything works with latest version that is on github :)  
P.P.S.: Assume that your API will be used by a frontend developer to build frontend on top of that.

-----------------------------

## Database configuration
In its default configuration, Voting Application uses an in-memory database (H2) which gets populated at startup with data.

## Description

Registered administrators can:
- Create and receive restaurants;
- create restaurant menu items;
- create, receive and delete users.

Any user (anonymous and logged in) can:
- get a list of restaurants with a rating >= 0 for the current day;
- get a rating of restaurants on the selected date;

Registered users can:
- Vote for the restaurant and cancel/change their vote before 11:00 am of the current day.

Built-in accounts in the app:
1) Username: user1@yandex.ru
Password: "password1" (user role)
2) Username: user2@yandex.ru
Password: "password2" (user role)
3) Username: user3@yandex.ru
Password: "password3" (user role)
4) Username: admin@gmail.com
Password: "admin" (administrator role)
5) Username: guest@yandex.ru
Password: "guest" (guest role)

## Curl Commands
The description of the REST API commands will be available at the link - http://localhost:8080/swagger-ui/index.html after the application is launched
