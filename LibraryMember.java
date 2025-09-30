public class LibraryMember {
    private String memberId;
    private String name;
    private String email;
    private String phoneNumber;
    private int borrowedBooks;
    private static final int MAX_BOOKS = 5;
    
    public LibraryMember(String memberId, String name, String email, String phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = 0;
    }
    
    public String getMemberInfo() {
        return String.format("Member ID: %s | Name: %s | Email: %s | Books Borrowed: %d/%d", 
                           memberId, name, email, borrowedBooks, MAX_BOOKS);
    }
    
    public boolean canBorrowBook() {
        return borrowedBooks < MAX_BOOKS;
    }
    
    public void borrowBook() {
        if (canBorrowBook()) {
            borrowedBooks++;
            System.out.println(name + " has borrowed a book. Total books: " + borrowedBooks);
        } else {
            System.out.println(name + " has reached the maximum borrowing limit (" + MAX_BOOKS + " books).");
        }
    }
    
    public void returnBook() {
        if (borrowedBooks > 0) {
            borrowedBooks--;
            System.out.println(name + " has returned a book. Total books: " + borrowedBooks);
        } else {
            System.out.println(name + " has no books to return.");
        }
    }
    
    // Getters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getBorrowedBooks() { return borrowedBooks; }
    public static int getMaxBooks() { return MAX_BOOKS; }
}