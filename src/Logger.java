
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class InfoLogger {
    public void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[INFO " + time + "] " + message);
    }
}

class WarnLogger {
    public void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[UWAGA " + time + "] " + message);
    }
}

class ErrorLogger {
    public void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[BŁĄD " + time + "] " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        InfoLogger info = new InfoLogger();
        WarnLogger warn = new WarnLogger();
        ErrorLogger error = new ErrorLogger();

        info.log("Info");
        warn.log("Uwaga");
        error.log("Błąd");
    }
}
