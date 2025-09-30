public class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;
    
    public Book(String isbn, String title, String author, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }
    
    public String getBookInfo() {
        String status = isAvailable ? "Available" : "Checked Out";
        return String.format("ISBN: %s | %s by %s | Genre: %s | Status: %s", 
                           isbn, title, author, genre, status);
    }
    
    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + title + "' has been borrowed successfully.");
            return true;
        } else {
            System.out.println("Book '" + title + "' is currently unavailable.");
            return false;
        }
    }
    
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book '" + title + "' has been returned successfully.");
        } else {
            System.out.println("Book '" + title + "' was not checked out.");
        }
    }
    
    // Getters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public boolean isAvailable() { return isAvailable; }
}