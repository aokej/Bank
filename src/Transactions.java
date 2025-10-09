import java.util.Scanner;

public class Transaction {

    Scanner myObj = new Scanner(System.in);

    public void transakcje(String[] args, int a, int b, int c, double balans){
        if(a == 0){
            System.out.println("Jaką kwotę chcesz wpłacić");
            Scanner myObj = new Scanner(System.in);

            int wplata = Integer.parseInt(myObj.nextLine());

            user.balans == user.balans + wplata;

        } else if (a == 1) {
            System.out.println("Jaką kwotę chcesz wyplcić");
            Scanner myObj = new Scanner(System.in);

            int wyplata = Integer.parseInt(myObj.nextLine());

            if(user.balans > wyplata) {

                user.balans == user.balans - wyplata;

            }else{
                System.out.println("Nie masz wystarczającej ilości środków na koncie");
            }
        } else if (a == 2) {
            System.out.println("podaj id usera któemu chcesz przelać śrdoki");

            int userid = Integer.parseInt(myObj.nextLine());
            int kwotaprzelewu = Integer.parseInt(myObj.nextLine());
            if(user.balans > kwotaprzelewu){
                user.balans == user.balans - kwotaprzelewu;
                userid.balans == userid.balans + kwotaprzelewu;
            }else{
                System.out.println("Nie masz takich srodków na koncie");
            }
        } else {
            System.out.println("Wystąpił błąd podczas operacji");
        }
    }
}
