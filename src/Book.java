// package src;

public class Book {
    // VARIABLES 
    private int bookNumber;
    private String bookTitle;
    private String bookAuthor;
    private String bookLocation;
    private String bookFormat;
    // BINARY SEARCH TREE
    private Book data;
    private Book left;
    private Book right;

    // GETTERS 
    public int getBookNumber() {
        return bookNumber;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public String getBookLocation() {
        return bookLocation;
    }
    public String getBookFormat() {
        return bookFormat;
    }
    //BST GETTERS
    public Book getData() {
        return data;
    }
    public Book getLeft() {
        return left;
    }
    public Book getRight() {
        return right;
    }

    // SETTERS
    public void setBookNumber(int splitData) {
        this.bookNumber = splitData;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation;
    }
    public void setBookFormat(String bookFormat) {
        this.bookFormat = bookFormat;
    }
    // LINKED LIST SETTERS
    public void setData(Book data) {
        this.data = data;
    }
    public void setLeft(Book left) {
        this.left = left;
    }
    public void setRight(Book right) {
        this.right = right;
    }

    // CONSTRUCTOR
    public Book() {
        setData(data);
        setLeft(null);
        setRight(null);
    }

    @Override         
    public String toString() {                                                                    
        return String.format("\nTitle: %s\nAuthor: %s\nID: %d\nLocation: %s\nFormat: %s",
        getBookTitle(), getBookAuthor(), getBookNumber(), 
        getBookLocation(), getBookFormat());                         
    }
}
