import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Logger {
    void log(String message);
}

class InfoLogger implements Logger {
    @Override
    public void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[INFO " + time + "] " + message);
    }
}

class WarnLogger implements Logger {
    @Override
    public void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[UWAGA " + time + "] " + message);
    }
}

class ErrorLogger implements Logger {
    @Override
    public void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[BŁĄD " + time + "] " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger info = new InfoLogger();
        Logger warn = new WarnLogger();
        Logger error = new ErrorLogger();

        info.log("Zalogowano użytkownika do systemu bankowego.");
        warn.log("Próba logowania z nieznanego urządzenia.");
        error.log("Nieudana autoryzacja przelewu!");
    }
}
