package com.jk.model.payment;

import java.io.Serializable;

public class Payment implements Serializable {
    private Integer id;

    private String  payment_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", payment_name='" + payment_name + '\'' +
                '}';
    }
}
