package pl.com.bottega.exchangerate.ui;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.exchangerate.api.AdminPanel;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateCommand;

/**
 * Created by maciek on 13.05.2017.
 */
@RestController
@RequestMapping
public class ExchangeRateController {

    private AdminPanel adminPanel;
    public ExchangeRateController(AdminPanel adminPanel){
        this.adminPanel = adminPanel;
    }

    @PutMapping("/exchange-rate")
    public void defineExchangeRate(@RequestBody ExchangeRateCommand cmd){
        adminPanel.saveExchangeRate(cmd);
    }


}
