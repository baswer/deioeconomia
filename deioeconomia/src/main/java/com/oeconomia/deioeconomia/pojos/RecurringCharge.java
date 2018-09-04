package com.oeconomia.deioeconomia.pojos;

/**
 * @author Sebastian Weiner on 2017-07-14.
 */
public class RecurringCharge
{
    private String name;
    private Boolean income;
    private Double value;
    private RecurrenceType recurrence;
    private Integer recurrenceMultiplication;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Boolean getIncome()
    {
        return income;
    }

    public void setIncome(Boolean income)
    {
        this.income = income;
    }

    public Double getValue()
    {
        return value;
    }

    public void setValue(Double value)
    {
        this.value = value;
    }

    public RecurrenceType getRecurrence()
    {
        return recurrence;
    }

    public void setRecurrence(RecurrenceType recurrence)
    {
        this.recurrence = recurrence;
    }

    public Integer getRecurrenceMultiplication()
    {
        return recurrenceMultiplication;
    }

    public void setRecurrenceMultiplication(Integer recurrenceMultiplication)
    {
        this.recurrenceMultiplication = recurrenceMultiplication;
    }
}
