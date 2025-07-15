# 📚 Library Management System (Java Console-Based)

A simple, modular, console-based **Library Management System** built using **pure Java**. The system allows Admins to manage books and users, while Students can view, borrow, and return books. Data is stored in local CSV files without any external database.

---

## 🚀 Features

### 👨‍🏫 Admin
- Add new books
- View all books
- Add new users (Admins or Students)
- View all users

### 👩‍🎓 Student
- View available books
- Borrow a book
- Return a book

### 🗃️ Data Persistence
- All data is stored and loaded from local `.csv` files:
  - `data/books.csv`
  - `data/users.csv`

---

## 🧱 Project Structure

LibraryManagementSystem/
├── src/
│ ├── main/
│ │ └── Main.java # Entry point
│ ├── models/ # Data models: User, Book, Admin, Student
│ ├── services/ # Core logic for books, users, borrowing
│ └── utils/ # File handling, validation, setup
├── data/
│ ├── books.csv # Stores book records
│ └── users.csv # Stores user records
---

## 🛠️ Tech Stack

- **Language:** Java (JDK 8+)
- **Storage:** CSV-based file system
- **IDE Recommended:** Eclipse / IntelliJ IDEA

---

## 🧪 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/Sakethreddy264/Library-Management-System.git
   cd Library-Management-System
2. Open in Eclipse or any IDE that supports Java.

3. Run Main.java from the src/main directory.

>This project is meant for learning Java OOP & file handling.

>Easily extendable to use databases or GUI frameworks later.


✍️ Author
Saketh Reddy
