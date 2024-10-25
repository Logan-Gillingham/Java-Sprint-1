public class Student extends Patron {
    private int studentID;

    public Student(String name, String address, String phoneNumber, int studentID) {
        super(name, address, phoneNumber);
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public boolean canBorrow() {
        int maxBorrowLimit = 5;
        return borrowedItems.size() < maxBorrowLimit;
    }
}