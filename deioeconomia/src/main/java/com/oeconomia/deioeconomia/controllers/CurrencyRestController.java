package com.oeconomia.deioeconomia.controllers;

import java.util.List;

import com.oeconomia.deioeconomia.manager.RemoteCurrenciesManager;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oeconomia.deioeconomia.pojos.CurrencyTable;

@RestController
public class CurrencyRestController {

    @RequestMapping(value="/currency", method=RequestMethod.GET, produces={"application/json"})
    public @ResponseBody List<CurrencyTable> currency(Model model) {
        RemoteCurrenciesManager currenciesManager = new RemoteCurrenciesManager("http://api.nbp.pl");
        List<CurrencyTable> rates = currenciesManager.getAllCurrencies();
        currenciesManager.save(rates);
        return rates;
    }

}
