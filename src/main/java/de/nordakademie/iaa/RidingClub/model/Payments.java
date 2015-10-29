package de.nordakademie.iaa.RidingClub.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Payments")
public class Payments implements Serializable {


    private static final long serialVersionUID = 6925248180274039273L;

    private Long id_payment;

    private String memberType;

    private int amount;

    //private int year;
    //private boolean status;

    private Member member;

    // Zahlungs-Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId_payment() {
        return id_payment;
    }
    public void setId_payment(Long id_payment) {
        this.id_payment = id_payment;
    }

    // Mitgliedsart
    public String getMemberType() {
        return memberType;
    }
    public void setMemberType(String type) {
        this.memberType = type;
    }

    // Jahresbeitrag
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    //Member
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Member", nullable = false)
    public Member getMember(){
        return this.member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
}


