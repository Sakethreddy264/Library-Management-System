package models;

public class Book {
	private String id;
	private String title;
	private String author;
	private boolean isIssued;

	public Book(String id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isIssued = false;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean issued) {
		this.isIssued = issued;
	}

	@Override
	public String toString() {
		return id + "," + title + "," + author + "," + isIssued;
	}

	public static Book fromcsv(String csv) {
		String[] parts = csv.split(",");
		Book b = new Book(parts[0], parts[1], parts[2]);
		b.setIssued(Boolean.parseBoolean(parts[3]));
		return b;
	}

}
