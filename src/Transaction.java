public class Transaction {

    public static void deposit(Account account, double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            String msg = "Wpłata: +" + amount + " PLN. Nowe saldo: " + account.getBalance() + " PLN";
            System.out.println(msg);
            account.getHistoria().dodajOperacje(msg);
        } else {
            String msg = "Nieprawidłowa kwota wpłaty!";
            System.out.println(msg);
            account.getHistoria().dodajOperacje(msg);
        }
    }

    public static void withdraw(Account account, double amount) {
        if (amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            String msg = "Wypłata: -" + amount + " PLN. Pozostałe saldo: " + account.getBalance() + " PLN";
            System.out.println(msg);
            account.getHistoria().dodajOperacje(msg);
        } else {
            String msg = "Błąd wypłaty: niewystarczające środki lub nieprawidłowa kwota!";
            System.out.println(msg);
            account.getHistoria().dodajOperacje(msg);
        }
    }

    public static void transfer(Account from, Account to, double amount) {
        if (amount > 0 && from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            String msgFrom = "Przelew: -" + amount + " PLN do " + to.getOwner() 
                + ". Pozostałe saldo: " + from.getBalance() + " PLN";
            String msgTo = "Otrzymano przelew: +" + amount + " PLN od " + from.getOwner() 
                + ". Nowe saldo: " + to.getBalance() + " PLN";

            System.out.println(msgFrom);
            System.out.println(msgTo);

            from.getHistoria().dodajOperacje(msgFrom);
            to.getHistoria().dodajOperacje(msgTo);
        } else {
            String msg = "Błąd przelewu: niewystarczające środki lub nieprawidłowa kwota!";
            System.out.println(msg);
            from.getHistoria().dodajOperacje(msg);
        }
    }
}
