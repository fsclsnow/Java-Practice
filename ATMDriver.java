public class ATMDriver {
    public static void main(String[] args) {
        ATM CenterCity = new ATMBankAmerica();
        System.out.println("Please enter your PIN");
        System.out.println("You entered 2222");
        System.out.println(CenterCity.verifyPIN("2222"));
        System.out.println("Please enter your PIN");
        System.out.println("You entered 1111");
        System.out.println(CenterCity.verifyPIN("1111"));
        String acc = CenterCity.selectAccount();
        System.out.println("You tried to withdraw $1200 from " + acc);
        CenterCity.display(acc, 1200,CenterCity.withdraw(acc, 1200));
        System.out.println("You tried to withdraw $400 from " + acc);
        CenterCity.display(acc, 400,CenterCity.withdraw(acc, 400));
        CenterCity.showBalance(acc);
    }
}
