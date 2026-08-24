package com.ms_prestamos.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public static class InvalidLoanAmount extends BusinessException{
        public InvalidLoanAmount (String message){ super(message);}
    }

    public static class NotExistException extends BusinessException{
        public NotExistException (String message){ super(message);}
    }

    public static class InvalidPaymentAmount extends BusinessException{
        public InvalidPaymentAmount (String message){ super(message);}
    }

    public static class PaymentExceedsRemainingBalance extends BusinessException{
        public PaymentExceedsRemainingBalance(String message){ super(message);}
    }

    public static class LoanIdNotExistException extends BusinessException{
        public LoanIdNotExistException (String message){ super(message);}
    }

}
