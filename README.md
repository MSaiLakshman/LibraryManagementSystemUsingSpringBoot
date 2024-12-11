# Library Management System Using Spring Boot

This project is a **Library Management System** built using **Spring Boot**, **JSP**, **CSS**, and **JavaScript**. It allows users to manage and track library books, issue and return books, and manage user accounts. The application uses a simple interface to perform CRUD operations on books and users, providing an easy-to-use system for managing library resources.

## Features

- **User Registration & Login**: Users can register and log in to access the system.
- **Book Management**: Admin can add, update, and delete books.
- **Book Issue & Return**: Users can issue and return books.
- **View Books**: Both users and admin can view available books.
- **Search Functionality**: Users can search for books by title, author, or genre.
- **Admin Dashboard**: Admin can manage users, books, and transactions.

## Technologies Used

- **Spring Boot**: Backend framework for building the application.
- **JSP**: Used for rendering views in the application.
- **CSS**: For styling the front end.
- **JavaScript**: For client-side scripting.
- **MySQL**: Database to store user, book, and transaction data.
- **Spring Data JPA**: ORM for managing database interactions.

## Project Structure

- **Controller**: Manages HTTP requests and returns responses.
- **Service**: Contains the business logic of the application.
- **Repository**: Interfaces for database interactions.
- **Model**: Represents the entity classes (User, Book, etc.).
- **Resources**: Contains JSP files for views and static files like CSS and JavaScript.

## Setup & Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/MSaiLakshman/LibraryManagementSystemUsingSpringBoot.git
    ```

2. **Install Dependencies**:
   - Make sure you have **Java** and **Maven** installed.
   - Use the following command to install the required dependencies:

    ```bash
    mvn clean install
    ```

3. **Database Setup**:
   - Set up a MySQL database and configure the `application.properties` file with the database credentials.

    Example:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/library_db
    spring.datasource.username=root
    spring.datasource.password=password
    ```

4. **Run the Application**:
    - Run the application using the following command:

    ```bash
    mvn spring-boot:run
    ```

5. **Access the Application**:
   - Open your browser and go to `http://localhost:8080`.

## Screenshots

Include some screenshots of your application here to demonstrate its UI and functionality.

## Contributing

Feel free to fork the repository, create a branch, and submit a pull request. Contributions to improve the system are always welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

You can modify this to match your project details more closely, especially if you have any specific setup steps or additional features.
