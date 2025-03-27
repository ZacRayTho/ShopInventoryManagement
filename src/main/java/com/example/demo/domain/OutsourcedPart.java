package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part{
String companyName;

    public OutsourcedPart() {
    }

    public OutsourcedPart(long id, String name, double price, int inv, String companyName, int minInv, int maxInv) {  
    this.id = id;
    this.name = name;
    this.price = price;
    this.inv = inv;
    this.companyName = companyName;
    this.minInv = minInv;
    this.maxInv = maxInv;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
