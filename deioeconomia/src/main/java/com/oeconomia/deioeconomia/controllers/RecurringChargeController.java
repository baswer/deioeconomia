package com.oeconomia.deioeconomia.controllers;

import com.oeconomia.deioeconomia.manager.RecurringChargeManager;
import com.oeconomia.deioeconomia.pojos.RecurrenceType;
import com.oeconomia.deioeconomia.pojos.RecurringCharge;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;


/**
 * @author Sebastian Weiner on 2017-07-14.
 */
@Controller
public class RecurringChargeController
{
    @RequestMapping(value="/recurringCharges", method = RequestMethod.GET)
    public String getCharges(Map<String, Object> model) {
        RecurringChargeManager recurringChargeManager = new RecurringChargeManager();
        List<RecurringCharge> recurringCharges = recurringChargeManager.getCharges();
        model.put("charges", recurringCharges);
        return "recurringCharges";
    }

    @RequestMapping(value="/addRecurringCharges", method = RequestMethod.GET)
    public String addCharges(Map<String, Object> model) {
       List<RecurrenceType> recurrenceTypes = new ArrayList<RecurrenceType>(EnumSet.allOf(RecurrenceType.class));
       RecurringCharge recurringCharge = new RecurringCharge();
       model.put("recurringCharge", recurringCharge);
       model.put("recurrenceTypes", recurrenceTypes);
       return "addRecurringCharges";
    }

    @RequestMapping(value="/saveRecurringCharges", params={"save"}, method = RequestMethod.POST)
    public String saveCharges(@ModelAttribute RecurringCharge recurringCharge, BindingResult result) {
        if(result.hasErrors()) {
            return "Doesn't work properly.";
        }
        RecurringChargeManager recurringChargeManager = new RecurringChargeManager();
        recurringChargeManager.save(recurringCharge);
        return "redirect:/recurringCharges";
    }
}
