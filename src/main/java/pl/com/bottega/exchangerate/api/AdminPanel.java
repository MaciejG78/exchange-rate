package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.commands.ExchangeRateCommand;

/**
 * Created by maciek on 13.05.2017.
 */
public interface AdminPanel {

    void saveExchangeRate(ExchangeRateCommand cmd);
}
