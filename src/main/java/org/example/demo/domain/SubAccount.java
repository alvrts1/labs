package org.example.demo.domain;

public class SubAccount {
    private Long id;

    private String name;

    private int number;

    private Long accountId;

    private AccountPlan accountPlan;

    public SubAccount(){}

    public SubAccount(String name, int number, AccountPlan accountPlan){
        this.name = name;
        this.number = number;
        this.accountPlan = accountPlan;
    }

    public SubAccount(String name, int number, AccountPlan accountPlan, Long accountId){
        this.name = name;
        this.number = number;
        this.accountPlan = accountPlan;
        this.accountId = accountId;
    }

    public SubAccount(Long id,String name, int number, AccountPlan accountPlan, Long accountId){
        this.id = id;
        this.name = name;
        this.number = number;
        this.accountPlan = accountPlan;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountPlan() {
        return accountPlan.getName();
    }

    public void setAccountPlan(AccountPlan accountPlan) {
        this.accountPlan = accountPlan;
    }

    @Override
    public String toString() {
        return "SubAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", accountPlan=" + accountPlan.getName() +
                '}';
    }
}
