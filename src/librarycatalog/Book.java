package librarycatalog;

public class Book {
    private String title;
    private String author;
    private long ISBN;
    private int publicationYear;

    public Book(String title, String author, long ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getISBN() {
        return ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}
