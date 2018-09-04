package com.oeconomia.deioeconomia.manager;

import com.oeconomia.deioeconomia.config.SpringMongoConfig;
import com.oeconomia.deioeconomia.pojos.CurrencyTable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RemoteCurrenciesManager {

    protected RestTemplate restTemplate;

    protected String serviceUrl;

    /**
     * Create an instance.
     *
     * @param serviceUrl
     *            The URL needed to access the microservice using REST.
     */
    public RemoteCurrenciesManager(String serviceUrl) {
        if(this.serviceUrl == null)
        {
            this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
        }

        if(this.restTemplate == null)
        {
            this.restTemplate = new RestTemplate();
        }
    }


    public String getInfo() {
        // Implementation info for debugging purposes
        return "remote";
    }

    public List<CurrencyTable> getAllCurrencies() {
        CurrencyTable[] currencies = restTemplate.getForObject(this.serviceUrl + "/api/exchangerates/tables/c?format=json", CurrencyTable[].class);
        return Arrays.asList(currencies);
    }


    public void save(List<CurrencyTable> rates) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        for (CurrencyTable currencyTable : rates) {
            mongoOperation.save(currencyTable);
        }
    }


    public CurrencyTable getCurrenciesForDate(String date) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        CurrencyTable currencyTable = mongoOperation.findOne(
                new Query(Criteria.where("effectiveDate").is(date)), CurrencyTable.class);
        return currencyTable;
    }

}
