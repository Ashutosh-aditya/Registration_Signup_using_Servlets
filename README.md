# Registration and Signing Using Servlets

This project implements a user registration and login system using Java Servlets. Users can register with their details and subsequently log in using their credentials.Try it using on eclipse Java-EE-perspective.

## Features

- User Registration
- User Login
- Form validation
- Database integration (MySQL)

## Screenshots

### Registration Page
![image](https://github.com/user-attachments/assets/c280c1a9-4324-4f51-8ab6-04847b8f2349)

### Login Page
![image](https://github.com/user-attachments/assets/90a54d6a-3676-48bc-9855-3c2eb5a99d0d)




## Project Structure
```
└── 📁Registration_Signup_using_Servlets
    └── .classpath
    └── .gitignore
    └── .project
    └── 📁.settings
    └── 📁build
        └── 📁classes
            └── 📁com
                └── 📁data
                    └── Login.class
                    └── Register_user.class
    └── README.md
    └── 📁src
        └── 📁main
            └── 📁java
                └── 📁com
                    └── 📁data
                        └── Login.java
                        └── Register_user.java
            └── 📁webapp
                └── login.html
                └── 📁META-INF
                    └── MANIFEST.MF
                └── register.html
                └── 📁WEB-INF
                    └── lib
```



## Installation

1. Clone the repository:
    ```sh
    git clone <repository_url>
    ```

2. Import the project into your preferred IDE (Eclipse, IntelliJ IDEA, etc.)

3. Ensure you have the MySQL connector in your classpath. If not, add it manually:
    ```sh
    Registration_Signup_using_Servlets/src/main/webapp/WEB-INF/lib/mysql-connector-java-8.0.28.jar
    ```

4. Set up the MySQL database:
    ```sql
    CREATE DATABASE users;
    USE users;

    CREATE TABLE records (
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        phone VARCHAR(20) NOT NULL,
        age INT NOT NULL,
        gender ENUM('Male', 'Female') NOT NULL,
        PRIMARY KEY (id),
        CONSTRAINT records_chk_1 CHECK ((age > 0))
    ) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    ```

5. Configure the database connection in your servlets (`Login.java` and `Register_user.java`):
    ```java
    // Example configuration
    String url = "jdbc:mysql://localhost:3306/users";
    String username = "root";
    String password = "your_password";
    ```

6. Deploy the project on a servlet container (e.g., Apache Tomcat).

## Usage

1. Access the registration page:
    ```
    http://localhost:8080/Registration_Signup_using_Servlets/register.html
    ```

2. Access the login page:
    ```
    http://localhost:8080/Registration_Signup_using_Servlets/login.html
    ```

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a Pull Request.
7. Can store password after hashing to add extra layer of Security.


