package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.Calculation;
import pl.com.bottega.exchangerate.domain.CalculationResult;
import pl.com.bottega.exchangerate.domain.commands.CalculateExchangeCommand;
import pl.com.bottega.exchangerate.infrastructure.ExchangeCalculation;

/**
 * Created by maciek on 14.05.2017.
 */
public class StandardExchangeCalculation implements ExchangeCalculation {

    private Calculation calculation;

    public StandardExchangeCalculation(Calculation calculation) {
        this.calculation = calculation;
    }

    @Override
    public CalculationResult calculate(CalculateExchangeCommand cmd) {
        return calculation.calculate(cmd);
    }
}
