package pl.com.bottega.exchangerate.domain.repositories;

import pl.com.bottega.exchangerate.domain.ExchangeRate;

/**
 * Created by maciek on 13.05.2017.
 */
public interface ExchangeRateRepository {
    void put(ExchangeRate exchangeRate);

    ExchangeRate get(String date, String currency);

}
