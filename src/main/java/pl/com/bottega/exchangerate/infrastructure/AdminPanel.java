package pl.com.bottega.exchangerate.infrastructure;

import pl.com.bottega.exchangerate.domain.commands.ExchangeRateCommand;
import pl.com.bottega.exchangerate.ui.ExchangeRateController;

/**
 * Created by maciek on 13.05.2017.
 */
public interface AdminPanel {

    void saveExchangeRate(ExchangeRateCommand cmd);
}
