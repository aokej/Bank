//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;  // Import the Scanner class


public class Main {


    public static void main(String[] args) {
        boolean isloged = false;

        while (true) {

            System.out.println("1. Załóż konto");
            System.out.println("2. Zaloguj się na swoje konto lub wyloguj");
            System.out.println("3. Zamknij system");
            Scanner myObj = new Scanner(System.in);
            int loginregister = Integer.parseInt(myObj.nextLine());
            if (loginregister == 1) {
                String login = myObj.nextLine();
                String password = myObj.nextLine();
                String passwordre = myObj.nextLine();
                if (password.equals(passwordre)) {
                    System.out.println("Hasła zostało zresetowane");
                } else {
                    System.out.println("Hasła się nie zgadzaja");
                }


            } else if (loginregister == 2){
                String login = myObj.nextLine();
                String password = myObj.nextLine();
                isloged = true;
            }else{
                System.out.println("System został zamknięty");
                break;
            }

            while (isloged) {
                System.out.println("Wybierz typ opracji:");
                System.out.println("1. Wpłać środki");
                System.out.println("2. Wypłać środki");
                System.out.println("3. Puść Przelew");
                System.out.println("4. Załuż lokate");
                System.out.println("5. Historia transakcji");
                System.out.println("6. Zmiana hasła");
                System.out.println("7. Wyloguj");

                int operationtype = Integer.parseInt(myObj.nextLine());

                if (operationtype == 1) {
                    int kwotadowpłaty = Integer.parseInt(myObj.nextLine());
                } else if (operationtype == 2) {
                    int kwotadowypłaty = Integer.parseInt(myObj.nextLine());
                } else if (operationtype == 3) {
                    int kwotadopzrelwu = Integer.parseInt(myObj.nextLine());
                } else if (operationtype == 4) {
                    int kwotanalokate = Integer.parseInt(myObj.nextLine());
                } else if (operationtype == 5) {
                    System.out.println("Historai operacji:");
                } else if (operationtype == 6) {
                    String newpassword = myObj.nextLine();
                    String newpasswordre = myObj.nextLine();
                    if (newpassword.equals(newpasswordre)) {
                            System.out.println("Hasła zostało zresetowane");
                    } else {
                        System.out.println("Hasła się nie zgadzaja");

                    }
                } else if (operationtype == 7) {
                    System.out.println("Zostałeś wylogowany");
                    break;
                }
            }
        }
    }
}
