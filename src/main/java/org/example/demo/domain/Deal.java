package org.example.demo.domain;

public class Deal {
    private Long id;

    private String agreement;

    private String tiker;

    private String order;

    private int number;

    private String date;

    private int quantity;

    private float price;

    private float totalCost;

    private String trader;

    private float commission;

    public Deal(){}

    public Deal(String agreement, String tiker, String order, int number, String date, int quantity, float price, float totalCost, String trader, float commission){
        this.agreement = agreement;
        this.tiker = tiker;
        this.order = order;
        this.number = number;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.totalCost = totalCost;
        this.trader = trader;
        this.commission = commission;
    }

    public Deal(Long id,String agreement, String tiker, String order, int number, String date, int quantity, float price, float totalCost, String trader, float commission){
        this.id = id;
        this.agreement = agreement;
        this.tiker = tiker;
        this.order = order;
        this.number = number;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.totalCost = totalCost;
        this.trader = trader;
        this.commission = commission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getTiker() {
        return tiker;
    }

    public void setTiker(String tiker) {
        this.tiker = tiker;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", agreement='" + agreement + '\'' +
                ", tiker='" + tiker + '\'' +
                ", order='" + order + '\'' +
                ", number=" + number +
                ", date='" + date + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalCost=" + totalCost +
                ", trader='" + trader + '\'' +
                ", commission=" + commission +
                '}';
    }
}
