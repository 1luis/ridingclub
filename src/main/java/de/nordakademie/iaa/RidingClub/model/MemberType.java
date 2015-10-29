package de.nordakademie.iaa.RidingClub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by 13115 on 28.10.2015.
 */
@Entity
@Table(name = "MemberType")
public class MemberType implements Serializable {

    private static final long serialVersionUID = 6925248180274039273L;

    @Id
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int amount;


    public String getMemberTypes() {
        return name;
    }

    public void setMemberTypes(String memberTypes) {
        name = memberTypes;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



}