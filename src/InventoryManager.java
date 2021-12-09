/*
Josh Reginaldo
Inventory Management Project
CIS 269-Y140

WEEK 15
    - Rework current array datastructure into a binary search tree
*/

// package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InventoryManager {
    // MAIN LINE
    public static void main(String[] args) throws Exception {
        // VARIABLES
        DataStructure bookCollection = new DataStructure();
        readData(bookCollection);

        // MENU LOOP
        Menu mainMenu = new Menu();
        int showMenu = mainMenu.displayMenu();


        while (showMenu != 5) {
            if (showMenu == 1) {
                System.out.print("Currently Adding to Inventory\n\n");
                boolean addCheck = bookCollection.addBook(promptForNewBook());

                displayAddResult(addCheck); // Add function to display success or fail message to keep loop fairly clean

                showMenu = mainMenu.displayMenu();
            }
             else if (showMenu == 2) {
                 System.out.print("Currently Deleting from Inventory\n\n");
                 bookCollection.deleteBook(promptForISBN());

                 showMenu = mainMenu.displayMenu();
             }
            else if (showMenu == 3) {
                System.out.print("Currently Updating Inventory\n\n");
                bookCollection.updateBook(promptForISBN());

                showMenu = mainMenu.displayMenu();
            }
            else if (showMenu == 4) {
                System.out.print("Currently Displaying Inventory\n\n");
                bookCollection.displayAll();

                showMenu = mainMenu.displayMenu();
            }
            else {
                System.out.print("Invalid Choice\n\n");

                showMenu = mainMenu.displayMenu();
            }
        }
        System.out.print("Successfully Exited the Program");
    }

    // FUNCTIONS
    public static void displayAddResult(Boolean boolCheck) {
        if (boolCheck == true) {
            System.out.println("\n===============================" +
                               "\nSuccessfully added to inventory" +
                               "\n===============================");
        }
        else {
            System.out.println("\n==========================" +
                               "\nFailed to add to inventory" +
                               "\n==========================");
        }
    }

    public static void readData(DataStructure bookCollection) throws FileNotFoundException {
        // Variables
        int i = 0;

        // Open file(s) for reading
        File intData = new File("src\\assets\\books_new.txt");          
        Scanner fileReader = new Scanner(intData);                      

        while (fileReader.hasNextLine()) {                              
            String fileData = fileReader.nextLine();                    
            String[] splitData = fileData.split(",");                   

            Book newBook = new Book();                                  
            newBook.setBookTitle(splitData[0]);                         
            newBook.setBookAuthor(splitData[1]);                        
            newBook.setBookNumber(Integer.parseInt(splitData[2]));      
            newBook.setBookLocation(splitData[3]);                      
            newBook.setBookFormat(splitData[4]);                        

            newBook.setData(newBook);                                   
            bookCollection.addBook(newBook);                            

            i++;                                                        
        }
        fileReader.close();
    }

    public static int promptForISBN() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ISBN Number: ");
        int bookISBN = scan.nextInt();

        return bookISBN;
    }

    public static Book promptForNewBook() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Book Title: ");
        String bookTitle = scan.nextLine();             

        System.out.println("Enter Book Author: ");
        String bookAuthor = scan.nextLine();            

        System.out.println("Enter Book Location: ");
        String bookLocation = scan.nextLine();          

        System.out.println("Enter Book Format: ");
        String bookFormat = scan.nextLine();            

        System.out.println("Enter ISBN Number: ");
        int bookISBN = scan.nextInt();                  

        Book newBook = new Book();                      
        newBook.setBookTitle(bookTitle);                
        newBook.setBookAuthor(bookAuthor);              
        newBook.setBookLocation(bookLocation);         
        newBook.setBookFormat(bookFormat);              
        newBook.setBookNumber(bookISBN);
        newBook.setData(newBook);                       

        return newBook;
    }
}