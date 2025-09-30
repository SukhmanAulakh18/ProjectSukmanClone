import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedSearch {
    private LibrarySystem library;
    
    public AdvancedSearch(LibrarySystem library) {
        this.library = library;
    }
    
    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : library.getCatalog()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }
    
    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : library.getCatalog()) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }
    
    public List<Book> searchByGenre(String genre) {
        List<Book> results = new ArrayList<>();
        for (Book book : library.getCatalog()) {
            if (book.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }
    
    public List<Book> searchAvailableBooks() {
        List<Book> results = new ArrayList<>();
        for (Book book : library.getCatalog()) {
            if (book.isAvailable()) {
                results.add(book);
            }
        }
        return results;
    }
    
    public List<Book> searchCheckedOutBooks() {
        List<Book> results = new ArrayList<>();
        for (Book book : library.getCatalog()) {
            if (!book.isAvailable()) {
                results.add(book);
            }
        }
        return results;
    }
    
    public List<LibraryMember> searchActiveMembers() {
        List<LibraryMember> results = new ArrayList<>();
        for (LibraryMember member : library.getMembers()) {
            if (member.getBorrowedBooks() > 0) {
                results.add(member);
            }
        }
        return results;
    }
    
    public List<LibraryMember> searchMembersByName(String name) {
        List<LibraryMember> results = new ArrayList<>();
        for (LibraryMember member : library.getMembers()) {
            if (member.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(member);
            }
        }
        return results;
    }
    
    public void displaySearchResults(String searchType, List<?> results) {
        System.out.println("\n=== " + searchType + " Search Results ===");
        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Found " + results.size() + " result(s):");
            for (Object item : results) {
                if (item instanceof Book) {
                    System.out.println("- " + ((Book) item).getBookInfo());
                } else if (item instanceof LibraryMember) {
                    System.out.println("- " + ((LibraryMember) item).getMemberInfo());
                }
            }
        }
    }
    
    public void performAdvancedSearch(String query) {
        System.out.println("\n=== Advanced Search for: '" + query + "' ===");
        
        // Search in all categories
        List<Book> titleResults = searchByTitle(query);
        List<Book> authorResults = searchByAuthor(query);
        List<Book> genreResults = searchByGenre(query);
        List<LibraryMember> memberResults = searchMembersByName(query);
        
        if (!titleResults.isEmpty()) {
            displaySearchResults("Title", titleResults);
        }
        if (!authorResults.isEmpty()) {
            displaySearchResults("Author", authorResults);
        }
        if (!genreResults.isEmpty()) {
            displaySearchResults("Genre", genreResults);
        }
        if (!memberResults.isEmpty()) {
            displaySearchResults("Member", memberResults);
        }
        
        if (titleResults.isEmpty() && authorResults.isEmpty() && 
            genreResults.isEmpty() && memberResults.isEmpty()) {
            System.out.println("No results found for '" + query + "'");
        }
    }
}