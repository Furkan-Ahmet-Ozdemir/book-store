# Book Store Project


Book Store is a Spring Boot project.


## Technologies Used
- **Java 17**
- **Spring Boot 3.2.2**
- **Spring Data JPA**
- **H2 Database**
- **Lombok** 
- **Swagger**

## Features
- CRUD Author
- CRUD Publisher
- CRUD Book.
- Search books using specifications (name, author, publisher, year of publication).
- API documentation with Swagger.

## Running the Project
1. Clone the repository.
2. Ensure you have Java 17 and Maven installed.
3. Navigate to the project directory and run:
   ```sh
   mvn spring-boot:run
   ```
4. The application will be available at `http://localhost:8082`.
5. Swagger documentation is available at `http://localhost:8082/swagger-ui.html`.

## Database Configuration
The application uses an in-memory **H2 Database** by default. The configuration can be changed in `application.properties` if needed.

# Book Store API Documentation

## Version 1.0

### Servers:
- [http://localhost:8082/swagger-ui.html/](http://localhost:8082/swagger-ui.html) - Generated server URL

---

## Publisher Controller

### Endpoints:

- **POST** `/api/publishers`
   - Create a new publisher.

- **PUT** `/api/publishers`
   - Update an existing publisher.

- **DELETE** `/api/publishers`
   - Delete a publisher.

- **GET** `/api/publishers/get-all`
   - Get all publishers.

---

## Book Controller

### Endpoints:

- **POST** `/api/books`
   - Create a new book.

- **PUT** `/api/books/{id}`
   - Update an existing book by ID.

- **DELETE** `/api/books/{id}`
   - Delete a book by ID.

- **GET** `/api/books/search`
   - Search books using specifications (e.g., author name, publisher name, etc.).

- **GET** `/api/books/get-all`
   - Get all books.

---

## Author Controller

### Endpoints:

- **POST** `/api/authors`
   - Create a new author.

- **PUT** `/api/authors`
   - Update an existing author.

- **DELETE** `/api/authors`
   - Delete an author.

- **GET** `/api/authors/load-test-data`
   - Load test data for authors.

- **GET** `/api/authors/get-all`
   - Get all authors.

---

## Example Usage:

### POST `/api/books` - Create a Book

#### Request Body:
```json
{
  "name": "The Great Gatsby",
  "yearOfPublication": 1925,
  "yearOfWritten": 1924,
  "numberOfPages": 218,
  "authorIdList": [1, 2],
  "publisherId": 1
}
