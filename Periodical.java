public class Periodical extends LibraryItem {
    private int issueNumber;
    private String publicationDate;

    public Periodical(int id, String title, Author author, String ISBN, String publisher, int numberOfCopies, int issueNumber, String publicationDate) {
        super(id, title, author, ISBN, publisher, numberOfCopies);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String getType() {
        return "Periodical";
    }
}