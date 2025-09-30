import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> catalog;
    private List<LibraryMember> members;
    
    public LibrarySystem() {
        this.catalog = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        catalog.add(book);
        System.out.println("Book added to catalog: " + book.getTitle());
    }
    
    public void registerMember(LibraryMember member) {
        members.add(member);
        System.out.println("Member registered: " + member.getName());
    }
    
    public boolean borrowBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        LibraryMember member = findMemberById(memberId);
        
        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return false;
        }
        
        if (member == null) {
            System.out.println("Member with ID " + memberId + " not found.");
            return false;
        }
        
        if (!member.canBorrowBook()) {
            System.out.println("Member has reached borrowing limit.");
            return false;
        }
        
        if (book.borrowBook()) {
            member.borrowBook();
            return true;
        }
        
        return false;
    }
    
    public boolean returnBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        LibraryMember member = findMemberById(memberId);
        
        if (book == null || member == null) {
            System.out.println("Book or member not found.");
            return false;
        }
        
        book.returnBook();
        member.returnBook();
        return true;
    }
    
    public void displayCatalog() {
        System.out.println("\n=== Library Catalog ===");
        if (catalog.isEmpty()) {
            System.out.println("No books in catalog.");
        } else {
            for (Book book : catalog) {
                System.out.println(book.getBookInfo());
            }
        }
    }
    
    public void displayMembers() {
        System.out.println("\n=== Library Members ===");
        if (members.isEmpty()) {
            System.out.println("No registered members.");
        } else {
            for (LibraryMember member : members) {
                System.out.println(member.getMemberInfo());
            }
        }
    }
    
    private Book findBookByIsbn(String isbn) {
        for (Book book : catalog) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    
    private LibraryMember findMemberById(String memberId) {
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}