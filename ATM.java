public interface ATM {
    boolean verifyPIN(String pin);
        /** Verifies a user's PIN.
         @param pin The user's PIN
         */

    String selectAccount();
        /** Allows the user to select an account.
         @return a String representing the account selected
         */

    boolean withdraw(String account, double amount);
        /** Withdraws a specified amount of money
         @param account The account from which the money comes
         @param amount The amount of money withdrawn
         @return whether or not the operation is successful
         */

    void display(String account, double amount, boolean success);
         /** Displays the result of an operation
         @param account The account from which money was withdrawn
         @param amount The amount of money withdrawn
         @param success Whether or not the withdrawal took place
         */

    void showBalance(String account);
         /** Displays an account balance
         @param account The account              selected
         */

}