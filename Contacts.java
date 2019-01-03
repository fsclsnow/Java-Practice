public class Contacts {
    private String FirstName, LastName, PhoneNumber, EmailAddress, Address;

    public Contacts(){
        FirstName = "";
        LastName = "";
        PhoneNumber = "";
        EmailAddress = "";
        Address = "";
    }

    public Contacts(Contacts c){
        FirstName = c.FirstName;
        LastName = c.LastName;
        PhoneNumber = c.PhoneNumber;
        EmailAddress = c.EmailAddress;
        Address = c.EmailAddress;
    }

    public Contacts (String _FirstName,String _LastName,String _PhoneNumber, String _EmailAddress, String _Address ){
        FirstName = _FirstName;
        LastName = _LastName;
        PhoneNumber = _PhoneNumber;
        EmailAddress = _EmailAddress;
        Address = _Address;
    }

    public String getFirstName(){
        return FirstName;
    }

    public String getLastName(){
        return LastName;
    }

    public String getPhoneNumber(){
        return PhoneNumber;
    }

    public String getEmailAddress(){
        return EmailAddress;
    }

    public String getAddress(){
        return Address;
    }

    public void setFirstName(String newFN){
        FirstName = newFN;
    }

    public void setLastName(String newLN){
        LastName = newLN;
    }

    public void setPhoneNumber(String newPN){
        PhoneNumber = newPN;
    }

    public void setEmailAddress(String newEA){
        EmailAddress = newEA;
    }

    public void setAddress(String newA){
        Address = newA;
    }

    public void print(){
        System.out.println("First Name: " + FirstName);
        System.out.println("Last Name: " + LastName);
        System.out.println("Phone Number: " + PhoneNumber);
        System.out.println("Email Address: " + EmailAddress);
        System.out.println("Address: " + Address + "\n");
    }


}
