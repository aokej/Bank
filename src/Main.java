import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Account> accounts = new ArrayList<>();
    private static TransactionHistory history = new TransactionHistory();
    private static Scanner scanner = new Scanner(System.in);
    private static Account currentAccount = null;
    public static boolean isLogged = false;

    public static void main(String[] args) {

        inicjalizujKontaNPC();


        System.out.println("   WITAJ UZYTKOWNIKU!!!!!!!!!!!!!!");

        boolean running = true;

        while (running) {
            if(isLogged == true){
                menuZalogowanego();
            }else if(isLogged == false){
                running = menuGlowne();
            }
        }

        scanner.close();

    }

    private static void inicjalizujKontaNPC() {
        // Tworzenie różnych typów kont
        Account konto1 = new Account("12345678", "Jan Kowalski", 5000.00);
        Account konto2 = new Account("87654321", "Piotr Nowak", 3500.00);
        BusinessAccount konto3 = new BusinessAccount("11223344", "Łukasz Tomczuk", 15000.00, "PGE");
        SavingsAccount konto4 = new SavingsAccount("99887766", "Maria Zielińska", 8000.00, "TAU");

        accounts.add(konto1);
        accounts.add(konto2);
        accounts.add(konto3);
        accounts.add(konto4);
    }

    private static boolean menuGlowne() {
        System.out.println("1. Zaloguj się na konto");
        System.out.println("2. Zarejsetruj koncto");
        System.out.println("3. Zakończ program");
        System.out.print("Wybierz opcję: ");

        try {
            int wybor = Integer.parseInt(scanner.nextLine());

            if(wybor == 1) {
                logowanie();
            }else if(wybor == 2) {
                rejestracja();
            }else if(wybor == 3) {
                return false;
            }else {
                System.out.println("Nieprawidłowa opcja!");
            }


        } catch (NumberFormatException e) {
            System.out.println("Proszę wprowadzić numer opcji!");
        }

        return true;
    }


    private static void rejestracja(){
        System.out.println("REJESTRACJA NOWEGO KONTA");
        System.out.print("Podaj imie właściciela: ");
        String imieWlasc = scanner.nextLine();
        System.out.print("Podaj nazwisko właściciela: ");
        String nazwWlasc = scanner.nextLine();
        String nrKont = "";

        boolean pomyslny = false;
        while(!pomyslny) {
            System.out.print("Podaj numer konta jaki chcesz miec: ");
            nrKont = scanner.nextLine();

            try {
                Long.parseLong(nrKont);
            } catch (NumberFormatException e) {
                System.out.println("numer konta musi zawierac same liczby!!");
                continue;
            }

            boolean istnieje = false;
            for (Account konto : accounts) {
                if (konto.getAccountNumber().equals(nrKont)) {
                    istnieje = true;
                    break;
                }
            }

            if (istnieje) {
                System.out.println("nie mozesz posiadac numeru konta: " + nrKont + " poniewaz posiada je juz inny uzytkownik!!");
            } else {
                Account newAcc = new Account(nrKont, imieWlasc+" "+nazwWlasc, 0);
                accounts.add(newAcc);
                System.out.println("Pomyslnie zarejestrowano konto!");
                pomyslny = true;
            }
        }
    }


    private static void logowanie() {
        System.out.println("LOGOWANIE");
        System.out.print("Podaj numer konta: ");
        String numerKonta = scanner.nextLine();

        for (Account konto : accounts) {
            if (konto.getAccountNumber().equals(numerKonta)) {
                currentAccount = konto;
                System.out.println("✓ Zalogowano pomyślnie!");
                System.out.println("Witaj, " + konto.getOwner() + "!");
                isLogged = true;
                return;
            }
        }

        System.out.println("✗ Nie znaleziono konta o podanym numerze.");
    }

    private static void menuZalogowanego() {
        System.out.println("KONTO: " + currentAccount.getOwner());
        System.out.println("Saldo: " + currentAccount.getBalance() + " PLN");
        System.out.println("1. Wpłać środki");
        System.out.println("2. Wypłać środki");
        System.out.println("3. Wykonaj przelew");
        System.out.println("4. Pokaż informacje o koncie");
        System.out.println("5. Historia transakcji");
        System.out.println("6. Wyloguj");
        System.out.print("Wybierz opcję: ");

        try {
            int wybor = Integer.parseInt(scanner.nextLine());

            if (wybor == 1) {
                wplac();
            } else if (wybor == 2) {
                wyplac();
            } else if (wybor == 3) {
                przelew();
            } else if (wybor == 4) {
                pokazInfoKonta();
            } else if (wybor == 5) {
                history.pokazHistorie();
            } else if (wybor == 6) {
                wyloguj();
            } else {
                System.out.println("Nieprawidłowa opcja!");
            }

        } catch (NumberFormatException e) {
            System.out.println("opcja jest liczba!!!");
        }
    }

    private static void wplac() {
        System.out.print("Podaj kwotę do wpłaty: ");
        try {
            double kwota = Double.parseDouble(scanner.nextLine());
            currentAccount.deposit(kwota);
            history.dodajOperacje("Wpłata: +" + kwota + " PLN na konto " + currentAccount.getAccountNumber());
        } catch (NumberFormatException e) {
            System.out.println("Nieprawidłowa kwota!");
        }
    }

    private static void wyplac() {
        System.out.print("Podaj kwotę do wypłaty: ");
        try {
            double kwota = Double.parseDouble(scanner.nextLine());
            double saldoPrzed = currentAccount.getBalance();
            currentAccount.withdraw(kwota);

            if (currentAccount.getBalance() < saldoPrzed) {
                history.dodajOperacje("Wypłata: -" + kwota + " PLN z konta " + currentAccount.getAccountNumber());
            }
        } catch (NumberFormatException e) {
            System.out.println("Nieprawidłowa kwota!");
        }
    }

    private static void przelew() {
        System.out.println("PRZELEW");
        System.out.print("Podaj numer konta odbiorcy: ");
        String numerOdbiorcy = scanner.nextLine();

        Account odbiorca = null;
        for (Account konto : accounts) {
            if (konto.getAccountNumber().equals(numerOdbiorcy)) {
                odbiorca = konto;
                break;
            }
        }

        if (odbiorca == null) {
            System.out.println("Nie znaleziono konta odbiorcy!");
            return;
        }

        if (odbiorca == currentAccount) {
            System.out.println("Nie możesz wykonać przelewu na własne konto!");
            return;
        }

        System.out.print("Podaj kwotę przelewu: ");
        try {
            double kwota = Double.parseDouble(scanner.nextLine());
            double saldoPrzed = currentAccount.getBalance();

            currentAccount.transfer(currentAccount, odbiorca, kwota);

            if (currentAccount.getBalance() < saldoPrzed) {
                history.dodajOperacje("Przelew: -" + kwota + " PLN z konta " +
                        currentAccount.getAccountNumber() + " do " + odbiorca.getAccountNumber() +
                        " (odbiorca: " + odbiorca.getOwner() + ")");
            }
        } catch (NumberFormatException e) {
            System.out.println("Nieprawidłowa kwota!");
        }
    }

    private static void pokazInfoKonta() {
        System.out.println("INFORMACJE O KONCIE");
        System.out.println("Numer konta: " + currentAccount.getAccountNumber());
        System.out.println("Właściciel: " + currentAccount.getOwner());
        System.out.println("Saldo: " + String.format("%.2f", currentAccount.getBalance()) + " PLN");

        if (currentAccount instanceof BusinessAccount) {
            BusinessAccount bizKonto = (BusinessAccount) currentAccount;
            System.out.println("Typ konta: Konto firmowe");
            System.out.println("Nazwa firmy: " + bizKonto.getCompanyName());
        } else if (currentAccount instanceof SavingsAccount) {
            SavingsAccount savKonto = (SavingsAccount) currentAccount;
            System.out.println("Typ konta: Konto oszczędnościowe");
            System.out.println("Program: " + savKonto.getClientName());
        } else {
            System.out.println("Typ konta: Konto standardowe");
        }
    }



    private static void wyloguj() {
        System.out.println("Zostałeś wylogowany. Do zobaczenia, " + currentAccount.getOwner() + "!");
        currentAccount = null;
        isLogged = false;
    }
}
