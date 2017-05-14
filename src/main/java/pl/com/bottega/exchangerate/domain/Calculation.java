package pl.com.bottega.exchangerate.domain;

import pl.com.bottega.exchangerate.domain.commands.CalculateExchangeCommand;

/**
 * Created by maciek on 13.05.2017.
 */
public class Calculation {

//TODO
    public CalculationResult calculate(CalculateExchangeCommand cmd) {

        CalculationResult calculationResult = new CalculationResult(cmd.getFrom(), cmd.getTo(), cmd.getAmount(), cmd.getAmount(), cmd.getDate());
        return calculationResult;
    }
}
