public class BankUtils {

    public static boolean isValidAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return false;
        }

        try {
            Long.parseLong(accountNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Account findAccountByNumber(java.util.List<Account> accounts, String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public static boolean accountNumberExists(java.util.List<Account> accounts, String accountNumber) {
        return findAccountByNumber(accounts, accountNumber) != null;
    }


    public static boolean validateTransfer(Account sender, Account recipient, double amount) {
        if (sender == null || recipient == null) {
            return false;
        }

        if (sender == recipient) {
            return false;
        }

        if (amount <= 0) {
            return false;
        }

        if (sender.getBalance() < amount) {
            return false;
        }

        return true;
    }




}