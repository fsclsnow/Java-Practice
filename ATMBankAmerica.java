import java.util.*;

public class ATMBankAmerica implements ATM {
    private Scanner in;
    private double CheckingBalance;
    private double SavingBalance;

    public ATMBankAmerica(){
        in = new Scanner(System.in);
        CheckingBalance = 1000.00;
        SavingBalance = 500.00;
    }

    @Override
    public boolean verifyPIN(String pin) {
        if (pin.equals("1111"))
            return true;
        else
            return false;
    }

    @Override
    public String selectAccount() {
        System.out.println("Please choose your account: ");
        System.out.println("C for checking account; ");
        System.out.println("A for saving account; ");
        String account = "a";
        do {
            String acc = in.next();
            if (acc.equalsIgnoreCase("c"))
                account = "checking account";
            if (acc.equalsIgnoreCase("a"))
                account = "saving account";
            else {
                System.out.println("Invalid input. Please try again. ");
            }
        }while (account.equals("a"));
        return account;
    }

    @Override
    public boolean withdraw(String account, double amount) {
        if (account.equals("checking account")&& amount < CheckingBalance) {
            CheckingBalance -= amount;
            return true;
        }
        if (account.equals("saving account")&& amount < SavingBalance) {
            SavingBalance -= amount;
            return true;
        }
        else
            return false;
    }

    @Override
    public void display(String account, double amount, boolean success) {
        if (success)    {
            System.out.println("You withdrawn: $" + amount + ".");
        }
    else {
            System.out.println("You do not have sufficient money in the " + account + ".");
        }
    }

    @Override
    public void showBalance(String account) {
        if (account.equals("checking account"))
            System.out.println("Your current balance in the " + account + " is $" + CheckingBalance);
        if (account.equals("saving account"))
            System.out.println("Your current balance in the " + account + " is $" + SavingBalance);
    }
}
