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


@Entity
@Table(name = "payments")
public class Payments implements Serializable {


    private static final long serialVersionUID = 6925248180274039273L;

  /*  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_payment",unique=true, nullable = false)*/
    private Long id_payment;

    @Column(name = "memberType")
    private String memberType;

    @Column(name = "amount")
    private int amount;

    @Column(name = "year")
    private int year;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name="idMember")
    private Member member;


    //**************************************************

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId_payment() {
        return id_payment;
    }
    public void setId_payment(Long id_payment) {
        this.id_payment = id_payment;
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


