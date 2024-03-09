# Forum Application

This is a simple internet forum backend application built with Spring Boot.

## Overview

The forum application implements full CRUD (Create, Read, Update, Delete) functionality for users, threads, and posts. Since my other projects were very database heavy - here I focused more on deploying the application and database itself using Docker.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Docker
- Docker Compose
- Postman

## Getting Started
To run the Forum application, follow these steps:

- Ensure you have Java Development Kit (JDK) and Docker installed on your system.
- Clone or download the project repository to your local machine.
- Navigate to the project directory:
  ```
  cd C:\{YOUR_PATH\Forum\Forum\src\main
  ```
- Build and run the Docker containers:
  ```
  docker-compose up --build
  ```
- Acces the application by using your desired software or web browser. (for example Postman)
- Feel free to test all the endpoints :)

## Configuration
The application is configured to use a PostgreSQL database. You can customize the database configuration by modifying the `docker-compose.yml` file.


# License
This project is licensed under the MIT License - see the LICENSE file for details.
