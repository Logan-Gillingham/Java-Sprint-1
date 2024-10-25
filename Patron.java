import java.util.List;
import java.util.ArrayList;

public abstract class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    public List<LibraryItem> borrowedItems;

    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public boolean returnItem(LibraryItem item) {
        if (borrowedItems.remove(item)) {
            return true;
        } else {
            return false;
        }
    }

    public void borrowItem(LibraryItem item) {
        if (item.isAvailable() && canBorrow()) {
            item.setAvailable(false);
            borrowedItems.add(item);
            System.out.println("Item borrowed successfully.");
        } else {
            System.out.println("Item is not available or you cannot borrow.");
        }
    }

    public abstract boolean canBorrow();

}

