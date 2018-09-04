package com.oeconomia.deioeconomia.manager;

import com.oeconomia.deioeconomia.config.SpringMongoConfig;
import com.oeconomia.deioeconomia.pojos.CurrencyTable;
import com.oeconomia.deioeconomia.pojos.RecurringCharge;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * @author Sebastian Weiner on 2017-07-14.
 */
public class RecurringChargeManager
{
    protected RestTemplate restTemplate;

    /**
     * Create an instance.
     */
    public RecurringChargeManager() {
        if(this.restTemplate == null)
        {
            this.restTemplate = new RestTemplate();
        }
    }

    public void save(RecurringCharge charge) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

            mongoOperation.save(charge);
    }

    public List<RecurringCharge> getCharges() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        return mongoOperation.findAll(RecurringCharge.class);
    }
}
