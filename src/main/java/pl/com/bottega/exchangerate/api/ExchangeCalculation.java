package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.CalculationResult;
import pl.com.bottega.exchangerate.domain.commands.CalculateExchangeCommand;

/**
 * Created by maciek on 14.05.2017.
 */
public interface ExchangeCalculation {

    public CalculationResult calculate(CalculateExchangeCommand cmd);
}
