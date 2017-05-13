package pl.com.bottega.exchangerate.domain;

import pl.com.bottega.exchangerate.domain.commands.ExchangeRateCommand;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by maciek on 13.05.2017.
 */
@Entity
public class ExchangeRate {
    
    @Id
    @GeneratedValue
    private Long id;

    private String date;
    private String currency;
    private BigDecimal rate;
    
    public ExchangeRate(){}
    
    public ExchangeRate(String date, String currency, BigDecimal rate){
        this.date = date;
        this.currency = currency;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if(this == null || o == null){
            return false;
        }
        if (!(o instanceof ExchangeRate)) return false;

        ExchangeRate other = (ExchangeRate) o;
        return (this.id == other.id);
    }

}
