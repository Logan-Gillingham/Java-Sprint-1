import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private List<Author> authors;
    private List<Patron> patrons;
    
    public Library() {
        this.items = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public LibraryItem getItemById(int id) {
        for (LibraryItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<LibraryItem> searchItems(String query) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    item.getAuthor().getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }


    public void borrowItem(Patron patron, LibraryItem item) {
        if (item.isAvailable() && patron.canBorrow()) {
            patron.borrowItem(item);
        }
    }

    public void returnItem(Patron patron, LibraryItem item) {
        patron.returnItem(item);
        item.setAvailable(true);
        System.out.println("Item returned successfully.");
    }

    public Patron getPatronById(int patronId) {
        for (Patron patron : patrons) {
            if (patron instanceof Student) {
                Student student = (Student) patron;
                if (student.getStudentID() == patronId) {
                    return student;
                }
            }
        }
        return null;
    }
}