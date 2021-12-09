// package src;
import java.util.Scanner;


public class Menu {
    public int displayMenu() {
        Scanner scan = new Scanner(System.in);
        String Menu = "\nWelcome to the Inventory Manager Program\n" +
                      "1 - Add to Inventory\n" +
                      "2 - Delete from Inventory\n" +
                      "3 - Update Inventory\n" +
                      "4 - Display All\n" +
                      "5 - Exit\n\n" +
                      "Your choice: ";

        System.out.printf("%s", Menu);
        
        int userChoice = scan.nextInt();
        if (userChoice >= 1 && userChoice <= 5) {
            return userChoice;
        }
        else {
            return -1;
        }
    }
}
