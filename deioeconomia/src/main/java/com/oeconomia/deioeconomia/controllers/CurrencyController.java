package com.oeconomia.deioeconomia.controllers;

import com.oeconomia.deioeconomia.manager.RemoteCurrenciesManager;
import com.oeconomia.deioeconomia.pojos.CurrencyTable;
import com.oeconomia.deioeconomia.pojos.Rates;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CurrencyController {

    @RequestMapping(value="/currency/{date}", method=RequestMethod.GET)
    public String currencyForDate(@PathVariable("date") String date, Map<String, Object> model) {
        RemoteCurrenciesManager currenciesManager = new RemoteCurrenciesManager("http://api.nbp.pl");

        if(date.equals("0")){
            Date today = new Date();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            date = dt.format(today);
        }

        CurrencyTable currencyTable = currenciesManager.getCurrenciesForDate(date);

        if(currencyTable != null){
            List<Rates> rates = new ArrayList<Rates>();
            Rates[] ratesTable = currencyTable.getRates();
            for (int i = 0; i < ratesTable.length; i++) {
                rates.add(ratesTable[i]);
            }
            model.put("rates", rates);
        }
        model.put("date", date);
        return "currencyForDate";
    }
}
