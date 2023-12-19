package org.example.demo.domain;

public class Operation {
    private Long id;

    private int number;

    private String date;

    private String type;

    private float sum;

    private float saldoInput;
    private float saldoOutput;

    private Long dealId;

    private Deal deal;

    private Long subAccountId;

    private SubAccount subAccount;

    public Operation(){}
    public Operation(int number, String date, String type, float sum, float saldoInput, float saldoOutput, Deal deal, SubAccount subAccount) {
        this.number = number;
        this.date = date;
        this.type = type;
        this.sum = sum;
        this.saldoInput = saldoInput;
        this.saldoOutput = saldoOutput;
        this.deal = deal;
        this.subAccount = subAccount;
    }

    public Operation(int number, String date, String type, float sum, float saldoInput, float saldoOutput, Deal deal, SubAccount subAccount,  Long dealId, Long subAccountId) {
        this.number = number;
        this.date = date;
        this.type = type;
        this.sum = sum;
        this.saldoInput = saldoInput;
        this.saldoOutput = saldoOutput;
        this.deal = deal;
        this.subAccount = subAccount;
        this.dealId = dealId;
        this.subAccountId = subAccountId;
    }

    public Operation(Long id,int number, String date, String type, float sum, float saldoInput, float saldoOutput, Deal deal, SubAccount subAccount,  Long dealId, Long subAccountId) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.type = type;
        this.sum = sum;
        this.saldoInput = saldoInput;
        this.saldoOutput = saldoOutput;
        this.deal = deal;
        this.subAccount = subAccount;
        this.dealId = dealId;
        this.subAccountId = subAccountId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public float getSaldoInput() {
        return saldoInput;
    }

    public void setSaldoInput(float saldoInput) {
        this.saldoInput = saldoInput;
    }

    public float getSaldoOutput() {
        return saldoOutput;
    }

    public void setSaldoOutput(float saldoOutput) {
        this.saldoOutput = saldoOutput;
    }

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public int getDeal() {
        return deal.getNumber();
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Long getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(Long subAccountId) {
        this.subAccountId = subAccountId;
    }

    public String getSubAccount() {
        return subAccount.getName();
    }

    public void setSubAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", number=" + number +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", sum=" + sum +
                ", saldoInput=" + saldoInput +
                ", saldoOutput=" + saldoOutput +
                ", deal=" + deal.getNumber() +
                ", subAccount=" + subAccount.getName() +
                '}';
    }
}
