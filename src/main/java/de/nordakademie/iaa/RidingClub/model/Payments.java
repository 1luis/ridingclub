package de.nordakademie.iaa.RidingClub.model;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Marc & Luis
 */

@Entity
@Table(name = "payments")
public class Payments implements Serializable {

    private static final long serialVersionUID = 6925248180274039273L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long payment_id;

    @Column(name = "year")
    private int year;

    @Column(name = "memberType")
    private String memberType;

    @Column(name = "amount")
    private int amount;

    @Column(name = "status")
    private String status;

    @ManyToOne
    //@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "MEMBER_FK")
    //@JoinColumn(foreignKey = @ForeignKey(name = "member_id"))
    private Member member;

    /**
     * Getters and Setters
     * @return
     */

    public Long getPayment_id() {
        return payment_id;
    }
    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public String getMemberType() {
        return memberType;
    }
    public void setMemberType(String type) {
        this.memberType = type;
    }


    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Member
/*    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Member", nullable = false)
    public Member getMember(){
        return this.member;
    }
    public void setMember(Member member) {
        this.member = member;
    }*/

    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}


