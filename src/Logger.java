
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
