public class Book extends LibraryItem {
    private String format; 

    public Book(int id, String title, Author author, String ISBN, String publisher, int numberOfCopies, String format) {
        super(id, title, author, ISBN, publisher, numberOfCopies);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String getType() {
        return "Book";
    }
}