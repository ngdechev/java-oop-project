package bg.tu_varna.sit;

public class Book {
    private String author;
    private String title;
    private String genre;
    private String description;
    private int releaseYear;
    private String keywords;
    private int rating;
    private String isbn;

    public Book(String author, String title, String genre, String description, int releaseYear, String keywords, int rating, String isbn) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.releaseYear = releaseYear;
        this.keywords = keywords;
        this.rating = rating;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getRating() {
        return rating;
    }

    public String getIsbn() {
        return isbn;
    }
}
