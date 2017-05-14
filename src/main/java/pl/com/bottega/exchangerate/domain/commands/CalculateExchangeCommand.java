package pl.com.bottega.exchangerate.domain.commands;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * Created by maciek on 13.05.2017.
 */
public class CalculateExchangeCommand implements Validatable {
    private String date;
    private String from;
    private String to;
    private BigDecimal amount;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public void validate(ValidationErrors errors) {
        if (date == null) {
            errors.add("date", "is required");

        } else {
            if (!Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", date))
                errors.add("date", "has invalid format");
        }
        if (from == null) {
            errors.add("from", "is required");
        } else {
            if (!Pattern.matches("^[A-Za-z]{3}$", from))
                errors.add("from", "has invalid format");
        }
        if (to == null) {
            errors.add("to", "is required");
        } else {
            if (!Pattern.matches("^[A-Za-z]{3}$", to)) {
                errors.add("to", "has invalid format");
            } else {
                if (from.equals(to)) {
                    errors.add("from", "must be different than to");
                    errors.add("to", "must be different than from");
                }
            }
        }
        if (amount == null) {
            errors.add("amount", "is required");
        } else {
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                errors.add("amount", "must be > than 0.0");
            } else {
                if (!Pattern.matches("^\\d+(\\.\\d{1,2})?$", amount.toString()))
                    errors.add("amount", "has invalid format");
            }
        }

    }
}
