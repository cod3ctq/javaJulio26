package exception;

public class DailyWithdrawalLimitExceededException extends RuntimeException {
  public DailyWithdrawalLimitExceededException(String message) {
    super(message);
  }
}
