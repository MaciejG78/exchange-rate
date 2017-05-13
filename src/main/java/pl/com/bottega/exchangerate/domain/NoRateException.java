package pl.com.bottega.exchangerate.domain;

public class NoRateException extends RuntimeException {
    public NoRateException(String entity, String date, String currency) {
        super(String.format("Entity: '%s' for date: '%s' and currency: '%s' does not exist", entity, date, currency));
    }
}
