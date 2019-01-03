import java.util.Scanner;

public class test {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        ContactList cl = new ContactList();
        System.out.println("Please enter search value: ");
        String value = sc.next();
        cl.remove(cl.search(value));
        cl.showAllContact();

    }
}
