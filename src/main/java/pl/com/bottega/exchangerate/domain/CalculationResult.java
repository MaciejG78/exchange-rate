package pl.com.bottega.exchangerate.domain;

import java.math.BigDecimal;

/**
 * Created by maciek on 13.05.2017.
 */

public class CalculationResult {
    String from;
    String to;
    BigDecimal amount;
    BigDecimal calculatedAmount;
    String date;

    public CalculationResult(String from, String to, BigDecimal amount, BigDecimal calculatedAmount, String date) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.calculatedAmount = calculatedAmount;
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public String getDate() {
        return date;
    }
}
