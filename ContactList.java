import java.util.*;

public class ContactList {
    private ArrayList<Contacts> ContactList;

    public ContactList(){
        ContactList = new ArrayList<Contacts>();
        setContactListDemo();
    }

    //setup a demo contact list
    public void setContactListDemo(){
        Contacts Alice = new Contacts ("Alice", "Smith", "1234567899", "AliceS@gmail.com","Lancaster 2341" );
        Contacts David = new Contacts("David", "White", "6542314569", "DavidW@gmail.com", "Pike Road 4535");
        Contacts Johnson = new Contacts ("Johnson","Stone", "7546216541", "JohnsonS@gmail.com", "Lean Avenue 901");
        Contacts Emma = new Contacts ("Emma", "Jackman", "1234527896","EmmaJ@yahoo.com","Walnut Lane 108");
        Contacts Lisa = new Contacts ("Lisa", "Jones", "4562130236","LisaJ@163.com", "Spruce Street 5421");
        ContactList.add(Alice);
        ContactList.add(David);
        ContactList.add(Johnson);
        ContactList.add(Emma);
        ContactList.add(Lisa);
    }

    //print out all contacts
    public void showAllContact(){
        for (Contacts c: ContactList){
            c.print();
        }
    }//end of method

    public void remove(Contacts c){
        ContactList.remove(c);//ContactList.indexOf(c)

    }

    //add a new contact
    public void addContact(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter First Name: ");
        String FN = in.next();
        System.out.println("Please enter Last Name: ");
        String LN = in.next();
        System.out.println("Please enter Phone Number: ");
        String PN = in.next();
        System.out.println("Please enter Email Address: ");
        String EA = in.next();
        System.out.println("Please enter Address: ");
        String A = in.next();
        A += in.nextLine();
        ContactList.add(new Contacts(FN,LN,PN,EA,A));
    }

    //search for the "value"
    public Contacts search(String value){
        for (Contacts c: ContactList){
            if (c.getFirstName().contains(value)){ return c;}
            if (c.getLastName().contains(value)){ return c;}
            if (c.getPhoneNumber().contains(value)){ return c;}
            if (c.getEmailAddress().contains(value)){ return c;}
            if (c.getAddress().contains(value)){ return c;}
        }
        return null;
    }//end of method

}
