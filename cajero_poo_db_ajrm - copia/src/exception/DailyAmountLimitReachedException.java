package exception;

public class DailyAmountLimitReachedException extends RuntimeException {
    public DailyAmountLimitReachedException(String message) {
        super(message);
    }
}
