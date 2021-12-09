// package src;
import  java.util.Scanner;

public class DataStructure {

    // VARIABLES
    private Book root;

    // GETTERS
    public Book getRoot() {
        return root;
    }
    
    // SETTERS
    public void setRoot(Book root) {
        this.root = root;
    }

    // FUNCTIONS
    public boolean addBook(Book newBook) {                                                                                    

        if (getRoot() == null) {
            setRoot(newBook);
        }
        else {
            Book branchNode = root;
            Book parentNode;

            while (true) {
                parentNode = branchNode;

                if (newBook.getBookNumber() < branchNode.getBookNumber()) {
                    branchNode = branchNode.getLeft();
                    if (branchNode == null) {
                        parentNode.setLeft(newBook);
                        return true;
                    }
                }
                else {
                    branchNode = branchNode.getRight();
                    if (branchNode == null) {
                        parentNode.setRight(newBook);
                        return true;
                    }
                }
            }
        }

        return true;
    }

    public void deleteBook(int bookISBN) {
        Book temp;
        Book node;
        Book current = getRoot();
        Book prev = null;

        while (current != null && current.getBookNumber() != bookISBN) {
            prev = current;
            if (current.getBookNumber() < bookISBN) {
                current = current.getRight();
            }
            else {
                current = current.getLeft();
            }
        }
        node = current;

        if (current != null && current.getBookNumber() == bookISBN) {
            if (node.getRight() == null) {
                node = node.getLeft();
            }
            else if (node.getData() == null) {
                node = node.getRight();
            }
            else {
                temp = node.getLeft();
                while (temp.getRight() != null) {
                    temp = temp.getRight();
                }
                temp.setRight(node.getRight());
                node = node.getLeft();
            }
            if (current == root) {
                root = node;
            }
            else if (prev.getLeft() == current) {
                prev.setLeft(node);
            }
            else {
                prev.setRight(node);
            }
        }
        else if (root != null) {
            System.out.println("Value was not found");
        }
        else {
            System.out.println("The tree is empty");
        }
    }

    public void updateBook(int bookISBN) {
        Book current = getRoot();
        searchBook(current, bookISBN);
    }

    private void searchBook(Book data, int BookISBN) {
        if (data != null) {
            if (data.getBookNumber() == BookISBN) {
                Scanner scan = new Scanner(System.in);

                System.out.println("Enter Book Title: ");
                String bookTitle = scan.nextLine();

                System.out.println("Enter Book Author: ");
                String bookAuthor = scan.nextLine();

                System.out.println("Enter Book Location: ");
                String bookLocation = scan.nextLine();

                System.out.println("Enter Book Format: ");
                String bookFormat = scan.nextLine();

                data.setBookTitle(bookTitle);
                data.setBookAuthor(bookAuthor);
                data.setBookLocation(bookLocation);
                data.setBookFormat(bookFormat);
            }
            else {
                searchBook(data.getLeft(), BookISBN);
                searchBook(data.getRight(), BookISBN);
            }
        }
    }

    private void inorder(Book data) {
        if (data != null) {
            inorder(data.getLeft());
            System.out.println(data.getData());
            inorder(data.getRight());
        }
    }

    public void displayAll() {
        Book root = getRoot();
        System.out.print("\nData displayed: 'in-order'\n");
        inorder(root);
    }
}
