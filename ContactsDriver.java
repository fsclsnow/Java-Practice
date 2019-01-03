import java.util.*;

public class ContactsDriver {

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        ContactList cl = new ContactList();
        String option = "";
        do {
            System.out.println("Please select your action: ");
            System.out.println("A for adding a new contact; ");
            System.out.println("P for printing all contacts: ");
            System.out.println("S for searching: ");
            System.out.println("Q for quit.");
            option = sc.next();
            switch (option) {
                case "A": {
                    cl.addContact();
                    break;
                }
                case "P": {
                    cl.showAllContact();
                    break;
                }
                case "S": {
                    System.out.println("Please enter search value: ");
                    String value = sc.next();
                    if (cl.search(value) != null) {
                        Contacts found = cl.search(value);
                        found.print();
                        System.out.println("Do you want to delete this contact? Please enter Yes or No. ");
                        String answer = sc.next();
                        if (answer.equals("Yes")) {
                            cl.remove(cl.search(value));
                            System.out.println("Contact deleted.");}//delete the found contact
                        else {System.out.println("Contact remains unchanged.");}
                    }
                    else {System.out.println("No record found.");}
                    break;
                    }
                case "Q": {
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }while( option!="Q" );//end of while loop when user select quit.
        System.out.println("End of operation. ");
    }
}//end of class
