import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private List<String> historia;

    public TransactionHistory() {
        historia = new ArrayList<>();
    }

    public void dodajOperacje(String opis) {
        historia.add(opis);
    }

    public void pokazHistorie() {
        if (historia.isEmpty()) {
            System.out.println("Brak tranzakcji w historii.");
        } else {
            System.out.println("Historia tranzakcji:");
            for (String operacja : historia) {
                System.out.println("- " + operacja);
            }
        }
    }
}
