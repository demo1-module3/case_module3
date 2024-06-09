package org.example.bai_case_module3.entity;

public class VerityMoney {
    private int verityMoneyId;
    private User userId;
    private Double money;
    private Status status;

    public VerityMoney() {
    }

    public VerityMoney(User userId, Double money) {
        this.userId = userId;
        this.money = money;
    }

    public VerityMoney(User userId, Double money, Status status) {
        this.userId = userId;
        this.money = money;
        this.status = status;
    }

    public VerityMoney(int verityMoneyId, User userId, Double money, Status status) {
        this.verityMoneyId = verityMoneyId;
        this.userId = userId;
        this.money = money;
        this.status = status;
    }

    public int getVerityMoneyId() {
        return verityMoneyId;
    }

    public void setVerityMoneyId(int verityMoneyId) {
        this.verityMoneyId = verityMoneyId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUserId(int userId) {

    }
}
