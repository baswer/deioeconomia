package com.oeconomia.deioeconomia.pojos;


public class CurrencyTable {

    private String table;
    private String no;
    private String tradingDate;
    private String effectiveDate;
    private Rates[] rates;

    public String getTable() {
        return table;
    }
    public void setTable(String table) {
        this.table = table;
    }
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getTradingDate() {
        return tradingDate;
    }
    public void setTradingDate(String tradingDate) {
        this.tradingDate = tradingDate;
    }
    public String getEffectiveDate() {
        return effectiveDate;
    }
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    public Rates[] getRates() {
        return rates;
    }
    public void setRates(Rates[] rates) {
        this.rates = rates;
    }
}
