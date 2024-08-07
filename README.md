# Registration and Signing Using Servlets

This project implements a user registration and login system using Java Servlets. Users can register with their details and subsequently log in using their credentials.

## Features

- User Registration
- User Login
- Form validation
- Database integration (MySQL)

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
                    ├── lib
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
    CREATE DATABASE user_db;
    USE user_db;

    CREATE TABLE users (
        id INT NOT NULL AUTO_INCREMENT,
        username VARCHAR(50) NOT NULL,
        password VARCHAR(50) NOT NULL,
        PRIMARY KEY (id)
    );
    ```

5. Configure the database connection in your servlets (`Login.java` and `Register_user.java`):
    ```java
    // Example configuration
    String url = "jdbc:mysql://localhost:3306/user_db";
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

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

