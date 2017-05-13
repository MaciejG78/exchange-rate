package pl.com.bottega.exchangerate.domain.commands;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * Created by maciek on 13.05.2017.
 */
public class ExchangeRateCommand implements Validatable {

    public String date;
    public String currency;
    public BigDecimal rate;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public void validate(ValidationErrors errors) {
        if (date == null) {
            errors.add("date", "is required");
        } else {
            if (!Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", date))
                errors.add("date", "has invalid format");
        }
        if (currency == null) {
            errors.add("currency", "is required");
        } else {
            if (!Pattern.matches("^[A-Za-z]{3}$", currency))
                errors.add("currency", "has invalid format");
        }
        if (rate == null) {
            errors.add("rate", "is required");
        } else {
            if (!Pattern.matches("^\\d+\\.\\d{1,4}$", rate.toString()))
                errors.add("rate", "must be > than 0.0");
        }
    }

}
