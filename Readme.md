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

Aşağıda, API endpoint'leri ve test case'leri içeren bir **Markdown (MD)** dosyası örneği bulacaksınız. Bu dosya, Book Store API'nin işlevlerini ve testlerini belgelendirmek için kullanılabilir.

---

# Book Store API Documentation

## Servers
- **Base URL**: `http://localhost:8082`

---

## API Endpoints

### **Book Controller**

| Method | Endpoint           | Description              |
|--------|--------------------|--------------------------|
| POST   | `/api/books`        | Create a new book        |
| PUT    | `/api/books/{id}`   | Update an existing book  |
| DELETE | `/api/books/{id}`   | Delete a book            |
| GET    | `/api/books`        | Get all books            |
| GET    | `/api/books/search` | Search books using specifications |

### **Publisher Controller**

| Method | Endpoint           | Description              |
|--------|--------------------|--------------------------|
| PUT    | `/api/publishers`   | Update an existing publisher |
| POST   | `/api/publishers`   | Create a new publisher   |
| DELETE | `/api/publishers`   | Delete a publisher       |
| GET    | `/api/publishers/get-all` | Get all publishers    |

### **Author Controller**

| Method | Endpoint              | Description                        |
|--------|-----------------------|------------------------------------|
| PUT    | `/api/authors`         | Update an existing author          |
| POST   | `/api/authors`         | Create a new author                |
| DELETE | `/api/authors`         | Delete an author                   |
| GET    | `/api/authors/load-test-data` | Load test data for authors    |
| GET    | `/api/authors/get-all` | Get all authors                    |

---

## Test Cases

### **POST /api/books** - Create a new book

#### Request
```json
{
  "name": "Test Book",
  "yearOfPublication": 2022,
  "yearOfWritten": 2021,
  "numberOfPages": 350,
  "authorIdList": [1, 2],
  "publisherId": 3
}
```

#### Expected Response
- Status Code: 201 Created
- Body:
```json
{
  "id": 1,
  "name": "Test Book",
  "yearOfPublication": 2022,
  "yearOfWritten": 2021,
  "numberOfPages": 350,
  "authorList": [
     "Author 1" ,
     "Author 2"
  ],
  "publisher":  "Publisher 1" 
}
```

---

### **PUT /api/books/{id}** - Update an existing book

#### Request
```json
{
  "name": "Updated Test Book",
  "yearOfPublication": 2023,
  "yearOfWritten": 2022,
  "numberOfPages": 400,
  "authorIdList": [2],
  "publisherId": 4
}
```

#### Expected Response
- Status Code: 200 OK
- Body:
```json
{
  "id": 1,
  "name": "Updated Test Book",
  "yearOfPublication": 2023,
  "yearOfWritten": 2022,
  "numberOfPages": 400,
  "authorList": [
     "Author 2" 
  ],
  "publisher":  "Publisher 2" 
}
```

---

### **DELETE /api/books/{id}** - Delete a book

#### Request
- Method: DELETE
- Endpoint: `/api/books/1`

#### Expected Response
- Status Code: 200 OK
- Body:
```json
{
  "true"
}
```

---

### **GET /api/books** - Get all books

#### Request
- Method: GET
- Endpoint: `/api/books`

#### Expected Response
- Status Code: 200 OK
- Body:
```json
[
  {
    "id": 1,
    "name": "Test Book",
    "yearOfPublication": 2022,
    "yearOfWritten": 2021,
    "numberOfPages": 350,
    "authorList": [
       "Author 1" ,
      "Author 2" 
    ],
    "publisher": "Publisher 1" 
  },
  {
    "id": 2,
    "name": "Another Book",
    "yearOfPublication": 2021,
    "yearOfWritten": 2020,
    "numberOfPages": 250,
    "authorList": [
    "Author 3"
    ],
    "publisher":  "Publisher 2"
  }
]
```

---

### **GET /api/books/search** - Search books using specifications

#### Request
```json
{
  "name": "Test",
  "authorName": "Author 1",
  "publisherName": "Publisher 1",
  "yearOfPublication": 2022
}
```

#### Expected Response
- Status Code: 200 OK
- Body:
```json
[
  {
    "id": 1,
    "name": "Test Book",
    "yearOfPublication": 2022,
    "yearOfWritten": 2021,
    "numberOfPages": 350,
    "authorList": [
       "Author 1",
       "Author 2"
    ],
    "publisher":  "Publisher 1"
  }
]
```

---

### **GET /api/publishers/get-all** - Get all publishers

#### Request
- Method: GET
- Endpoint: `/api/publishers/get-all`

#### Expected Response
- Status Code: 200 OK
- Body:
```json
[
  { "id": 1, "name": "Publisher 1" },
  { "id": 2, "name": "Publisher 2" },
  { "id": 3, "name": "Publisher 3" }
]
```

---

### **GET /api/authors/get-all** - Get all authors

#### Request
- Method: GET
- Endpoint: `/api/authors/get-all`

#### Expected Response
- Status Code: 200 OK
- Body:
```json
[
  { "id": 1, "name": "Author 1", "surName": " author 1" },
  { "id": 2, "name": "Author 2", "surName": " author 2" },
  { "id": 3, "name": "Author 3", "surName": " author 3" }
]
```

---

## Test Case Scenarios

### 1. Create a new book with valid data
- Test creating a book with valid `name`, `yearOfPublication`, `authorIdList`, and `publisherId`.
- Expected result: The book is created, and the correct response is returned with status 201.

### 2. Update an existing book with new data
- Test updating a book with a valid `bookId` and modified data.
- Expected result: The book is updated successfully, and the correct response is returned with status 200.

### 3. Delete a book by `bookId`
- Test deleting a book by valid `bookId`.
- Expected result: The book is deleted, and the correct response is returned with status 200.

### 4. Search books using valid specifications
- Test searching for books based on `name`, `authorName`, `publisherName`, and `yearOfPublication`.
- Expected result: The search results return books matching the specified criteria.

### 5. Get all publishers and authors
- Test retrieving the list of all publishers and authors.
- Expected result: A list of all publishers and authors is returned with status 200.
