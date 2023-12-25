# eLibrary Application

Welcome to the eLibrary application! This platform allows users to manage books, track borrow operations, and share books within a community. Below, you'll find detailed information about the database structures, models, functionalities, and API endpoints.

## Table of Contents

1. [Technologies Used](#technologies-used)
2. [Database Structures](#database-structures)
3. [Models](#models)
4. [Functionalities](#functionalities)
5. [API Endpoints](#api-endpoints)
6. [Example Usage](#example-usage)
7. [Getting Started](#getting-started)


## Technologies Used

- Java
- Spring Boot
- Hibernate
- MySQL
- Jakarta Persistence API (JPA)

## Database Structures

### Books Table

- **Columns:**
  - `bookId` (Primary Key): Unique identifier for each book.
  - `title`: Title of the book.
  - `author`: Author of the book.
  - `share`: Indicates whether the book is available for sharing.
  - `userId` (Foreign Key): Links to the owner's user ID in the Users table.
  - `AvailableToBorrow`: Indicates whether the book is available for borrowing.

### BorrowedBooks Table

- **Columns:**
  - `borrowId` (Primary Key): Unique identifier for each borrow operation.
  - `book_id` (Foreign Key): Links to the book being borrowed in the Books table.
  - `borrower_id` (Foreign Key): Links to the user borrowing the book in the Users table.
  - `borrowStartTime`: Timestamp indicating when the book was borrowed.
  - `borrowEndTime`: Timestamp indicating when the book is expected to be returned.
  - `returned`: Indicates whether the book has been returned.

### Users Table

- **Columns:**
  - `userId` (Primary Key): Unique identifier for each user.
  - `username`: Username associated with the user.
  - `email`: Email address associated with the user.

These tables establish relationships to maintain data integrity. For example, the `Books` and `BorrowedBooks` tables are linked by the `book_id` foreign key. The `BorrowedBooks` table references users through the `borrower_id` foreign key. These relationships facilitate tracking of book ownership, borrow operations, and user details in the eLibrary application.

## Functionalities

- **Add Books:** Users can add new books to the database, providing details such as title, author, and whether the book is open for sharing.

- **Share Books:** Books can be marked as shareable, allowing other users to borrow them.

- **Borrow Books:** Users can borrow books, specifying the borrowing period.

- **Return Books:** Users can mark borrowed books as returned, making them available for others to borrow again.

## API Endpoints

1. **GET /api/v1/booky**
   - Retrieve all books in the database.

2. **POST /api/v1/booky**
   - Add a new book to the database.
   - Request Body Example:
     ```json
     {
       "title": "Book Title",
       "author": "Author Name",
       "share": true,
       "userId": 1,
       "availableToBorrow": true
     }
     ```

3. **GET /api/v1/booky/shared**
   - Retrieve all books that are open for sharing.

4. **POST /api/v1/booky/{book_id}/borrow**
   - Borrow a book and add borrow details to the `BorrowedBooks` table.
   - Request Body Example:
     ```json
     {
       "borrowerId": 2,
       "borrowStartTime": "2023-12-25T12:00:00",
       "borrowEndTime": "2023-12-28T12:00:00"
     }
     ```

5. **PUT /api/v1/booky/{book_id}/borrow/{borrow_id}**
   - Update the database to mark the book as returned and available to borrow.

## Example Usage

### POST /api/v1/booky

```json
{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "share": true,
  "userId": 1,
  "availableToBorrow": true
}

## Getting Started
1. **Clone this repository.
2. **Set up the database configuration in application.properties.
3. **Run the application.
