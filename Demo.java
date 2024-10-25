import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.List;

public class Demo {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws ParseException {
        Library library = new Library();

        Author author1 = new Author("J.R.R. Tolkien", new Date(1892, 1, 3));
        Author author2 = new Author("J.K. Rowling", new Date(1965, 7, 31));
        Author author3 = new Author("Stephen King", new Date(1947, 9, 21));
        Author author4 = new Author("Stephen Hawking", new Date(1942, 1, 8));
        Author author5 = new Author("Jane Austen", new Date(1775, 12, 16));
        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);
        library.addAuthor(author4);
        library.addAuthor(author5);

        Book book1 = new Book(1, "The Lord of the Rings", author1, "0-547-93851-8", "Allen & Unwin", 5, "printed");
        Book book2 = new Book(2, "Harry Potter and the Sorcerer's Stone", author2, "0-545-13624-X", "Scholastic Inc.", 3, "printed");
        Book book3 = new Book(3, "The Shining", author3, "0-671-75773-8", "Doubleday", 2, "printed");
        Book book4 = new Book(4, "A Brief History of Time", author4, "0-553-05887-9", "Bantam Books", 3, "printed");
        Book book5 = new Book(5, "Pride and Prejudice", author5, "0-141-43948-7", "Penguin Books", 2, "printed");
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(book4);
        library.addItem(book5);

        Periodical periodical1 = new Periodical(6, "National Geographic", author3, "0027-9358", "National Geographic Society", 10, 123, "2023-11-15");
        Periodical periodical2 = new Periodical(7, "Scientific American", author1, "0036-8733", "Springer Nature", 8, 345, "2023-12-01");
        Periodical periodical3 = new Periodical(8, "Time Magazine", author4, "0040-781X", "Time Inc.", 15, 543, "2023-11-22");
        Periodical periodical4 = new Periodical(9, "National Geographic Kids", author5, "1522-8528", "National Geographic Society", 10, 234, "2023-12-15");
        library.addItem(periodical1);
        library.addItem(periodical2);
        library.addItem(periodical3);
        library.addItem(periodical4);

        Student student1 = new Student("Alice Johnson", "123 Main St", "123-456-7890", 12345);
        Student student2 = new Student("Charlie Brown", "567 Oak St", "987-654-3210", 56789);
        library.addPatron(student1);
        library.addPatron(student2);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Search Items");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item ID: ");
                    int itemId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter item title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author name: ");
                    String authorName = scanner.nextLine();
                    System.out.println("Enter authors birthday(dd/MM/yyyy): ");
                    String authorBirthday = scanner.nextLine();
                    Date authorBirthdate = new SimpleDateFormat("dd/MM/yyyy").parse(authorBirthday);
                    Author author = new Author(authorName, authorBirthdate);
                    System.out.println("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.println("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.println("Enter number of copies: ");
                    int numberOfCopies = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter format (printed, electronic, audio): ");
                    String format = scanner.nextLine();

                    Book book = new Book(itemId, title, author, isbn, publisher, numberOfCopies, format);
                    library.addItem(book);
                    break;
                case 2:
                    // Search for items by title or author
                    System.out.print("Enter search query: ");
                    String query = scanner.next().toLowerCase();
                    List<LibraryItem> results = library.searchItems(query);
                    if (results.isEmpty()) {
                        System.out.println("No items found. Make sure to check spelling");
                    } else {
                        System.out.println("Search Results:");
                        for (LibraryItem item : results) {
                            System.out.println("ID: " + item.getId());
                            System.out.println("Title: " + item.getTitle());
                            System.out.println("Author: " + item.getAuthor().getName());
                            System.out.println("ISBN: " + item.getISBN());
                            System.out.println("Publisher: " + item.getPublisher());
                            System.out.println("Number of Copies: " + item.getNumberOfCopies());
                            System.out.println("Available: " + item.isAvailable());
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    // Borrow an item
                    System.out.print("Enter item ID: ");
                    int itemIdToBorrow = scanner.nextInt();
                    System.out.print("Enter patron ID: ");
                    int patronId = scanner.nextInt();
                    LibraryItem itemToBorrow = library.getItemById(itemIdToBorrow);
                    Patron patron = library.getPatronById(patronId);
                    library.borrowItem(patron, itemToBorrow);
                    break;
                case 4:
                    // Return an item
                    System.out.print("Enter item ID: ");
                    int itemIdToReturn = scanner.nextInt();
                    System.out.print("Enter patron ID: ");
                    int returnPatronId = scanner.nextInt();
                    LibraryItem itemToReturn = library.getItemById(itemIdToReturn);
                    Patron returnPatron = library.getPatronById(returnPatronId);
                    library.returnItem(returnPatron, itemToReturn);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}