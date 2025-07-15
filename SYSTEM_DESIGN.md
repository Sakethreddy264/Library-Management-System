✅ 1. Functional Requirements
Core Features:
i. Admin login & functionality
    >Add/view books
    >Add/view users
ii. Student login & functionality
    >View books
    >Borrow books
    Return books
iii. Store data persistently
iv. Validate input

✅ 2. Non-Functional Requirements
i. Console-based
ii. No external database (CSV-based file storage)
iii. Extendable for new roles (e.g., librarian)
iv. Simple UI (text prompts)

✅ 3. Actor Identification
Actor      	          Responsibilities
Admin	          Add books, view all books, add/view users
Student      	  View books, borrow, and return books

✅ 4. Entity (Class) Identification
From the above, we identify the following key classes:
Class	                    Responsibility
--------------------------------------------------------------------------
Book	          Represents a book with ID, title, author, issued flag
User	          Abstract base class for common user data (id, name)
Admin	          Extends User, can manage books and users
Student        	Extends User, can borrow and return books
BookService	    Add/view/search books, save/load books from file
UserService	    Add/view users, authenticate, save/load users from file
BorrowService	  Borrow and return book logic
FileUtil	      Utility to read/write CSV files
InputValidator	Validate user input types
Initializer	    Populate default data and clean data files
Main	          Entry point, handles console interaction

✅ 5. Relationships
User (abstract)
│
├── Admin
└── Student

Main --> uses --> BookService
Main --> uses --> UserService
Main --> uses --> BorrowService

BookService <--> Book
UserService <--> User, Admin, Student
BorrowService <--> Book, Student

FileUtil <--> books.csv, users.csv

✅ 6. Data Flow (Simplified)
Start → Main.java
     → Ask user ID → UserService validates
         → If Admin → Admin menu:
             - Add Book → BookService → books.csv
             - View Users → UserService → users.csv
         → If Student → Student menu:
             - Borrow Book → BorrowService → update Book isIssued
             - Return Book → BorrowService → update Book isIssued
         → On every operation → FileUtil handles file I/O

 ✅ 7. Class Diagrams

🧩 1. Model Layer
      +----------------+
             |     User       |<<abstract>>
             +----------------+
             | - id: String   |
             | - name: String |
             +----------------+
             | +getId()       |
             | +getName()     |
             +----------------+
                  ▲     ▲
           +------+     +------+
           |                   |
   +---------------+   +----------------+
   |    Admin      |   |    Student     |
   +---------------+   +----------------+

   +---------------+
   |     Book      |
   +---------------+
   | - id: String  |
   | - title: String
   | - author: String
   | - isIssued: boolean
   +---------------+
   | +toString()   |
   | +fromCSV()    |
   +---------------+
   
⚙️ 2. Service Layer
+------------------+
|  BookService     |
+------------------+
| - books: List<Book>
+------------------+
| +addBook()       |
| +getAllBooks()   |
| +saveBooks()     |
| +loadBooks()     |
+------------------+

+------------------+
|  UserService     |
+------------------+
| - users: List<User>
+------------------+
| +addUser()       |
| +getAllUsers()   |
| +findUserById()  |
| +saveUsers()     |
| +loadUsers()     |
+------------------+

+----------------------+
|   BorrowService      |
+----------------------+
| +borrowBook(student, bookId)
| +returnBook(student, bookId)
+----------------------+

🛠 3. Utility Layer
+-------------------+
|   FileUtil        |
+-------------------+
| +readFile(path)   |
| +writeFile(path, lines)
+-------------------+

+-----------------------+
| InputValidator        |
+-----------------------+
| +isValidId(id: String)
+-----------------------+

+-------------------+
|  Initializer      |
+-------------------+
| +setupDefaults()  |
| +wipeDataFiles()  |
+-------------------+

🚀 4. Application Entry Point
+------------+
|  Main.java |
+------------+
| +main()    |
| +menus     |
+------------+

🔗 Relationships
Admin and Student inherit from User

Main uses all service and utility classes

BorrowService works with BookService and UserService

FileUtil used by BookService and UserService for persistence

