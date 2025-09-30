public class LibraryDemo {
    public static void main(String[] args) {
        System.out.println("=== Library Management System Demo ===");
        
        // Create library system
        LibrarySystem library = new LibrarySystem();
        
        // Add books to catalog
        System.out.println("\n--- Adding Books to Catalog ---");
        library.addBook(new Book("978-0134685991", "Effective Java", "Joshua Bloch", "Programming"));
        library.addBook(new Book("978-0321356680", "Effective C++", "Scott Meyers", "Programming"));
        library.addBook(new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman", "Programming"));
        library.addBook(new Book("978-1491950296", "Building Microservices", "Sam Newman", "Software Architecture"));
        
        // Register members
        System.out.println("\n--- Registering Members ---");
        library.registerMember(new LibraryMember("M001", "Alice Johnson", "alice@email.com", "555-0101"));
        library.registerMember(new LibraryMember("M002", "Bob Smith", "bob@email.com", "555-0102"));
        library.registerMember(new LibraryMember("M003", "Carol Davis", "carol@email.com", "555-0103"));
        
        // Display initial state
        library.displayCatalog();
        library.displayMembers();
        
        // Test borrowing books
        System.out.println("\n--- Testing Book Borrowing ---");
        library.borrowBook("978-0134685991", "M001"); // Alice borrows Effective Java
        library.borrowBook("978-0321356680", "M001"); // Alice borrows Effective C++
        library.borrowBook("978-0596009205", "M002"); // Bob borrows Head First Design Patterns
        
        // Try to borrow same book again (should fail)
        System.out.println("\n--- Testing Duplicate Borrowing ---");
        library.borrowBook("978-0134685991", "M002"); // Bob tries to borrow already borrowed book
        
        // Display updated state
        library.displayCatalog();
        library.displayMembers();
        
        // Test returning books
        System.out.println("\n--- Testing Book Returns ---");
        library.returnBook("978-0134685991", "M001"); // Alice returns Effective Java
        library.returnBook("978-0596009205", "M002"); // Bob returns Head First Design Patterns
        
        // Final state
        System.out.println("\n--- Final Library State ---");
        library.displayCatalog();
        library.displayMembers();
        
        System.out.println("\n=== Demo Complete ===");
    }
}