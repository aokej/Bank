import java.util.List;

public class BankReport {

    public static void generateReport(List<Account> accounts) {
        System.out.println("===== RAPORT BANKOWY =====");

        if (accounts == null || accounts.isEmpty()) {
            System.out.println("Brak kont do raportu.");
            return;
        }

        double suma = 0;
        for (Account acc : accounts) {
            suma += acc.getBalance();
            System.out.println("Konto: " + acc.getAccountNumber() + 
                               " | Właściciel: " + acc.getOwner() + 
                               " | Saldo: " + String.format("%.2f", acc.getBalance()) + " PLN");
        }

        System.out.println("---------------------------");
        System.out.println("Łączna suma sald wszystkich kont: " + String.format("%.2f", suma) + " PLN");
        System.out.println("===========================");
    }
}
