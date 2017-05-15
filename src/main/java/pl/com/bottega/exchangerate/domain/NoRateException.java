package pl.com.bottega.exchangerate.domain;

public class NoRateException extends RuntimeException {
    public NoRateException() {
        super("no exchange rate defined");
    }
}
