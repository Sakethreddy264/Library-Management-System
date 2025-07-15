package services;

import java.util.ArrayList;
import java.util.List;

import models.Book;
import utils.FileUtil;

public class BookService {
	private final String FILE_PATH = "data/books.csv";
	private List<Book> books;

	public BookService() {
		books = new ArrayList<>();
		loadBooks();
	}

	public void addBook(String id, String title, String author) {
		Book book = new Book(id, title, author);
		books.add(book);
		saveBook();
		System.out.println("Book added.");
	}

	public void printAllBooks() {
		if (books.isEmpty()) {
			System.out.println("No books found.");
			return;
		}
		for (Book book : books) {
			System.out.println(
					book.getId() + "|" + book.getTitle() + "|" + book.getAuthor() + "|Issued:" + book.isIssued());
		}
	}

	private void loadBooks() {
		List<String> lines = FileUtil.readFile(FILE_PATH);
		for (String line : lines) {
			books.add(Book.fromcsv(line));
		}
	}

	private void saveBook() {
		List<String> lines = new ArrayList<>();
		for (Book book : books) {
			lines.add(book.toString());
		}
		FileUtil.writeFile(FILE_PATH, lines);
	}
}
