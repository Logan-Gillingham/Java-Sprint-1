import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Author {
    private String name;
    private Date birthDate;
    private List<LibraryItem> writtenItems;

    public Author(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.writtenItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<LibraryItem> getWrittenItems() {
        return writtenItems;
    }

    public void addWrittenItem(LibraryItem item) {
        writtenItems.add(item);
    }
}