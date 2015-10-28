package de.nordakademie.iaa.RidingClub.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Payments")
public class Payments implements Serializable {


    private static final long serialVersionUID = 6925248180274039273L;

    private Long id_payment;

    private String type;


    private Member member;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId_payment() {
        return id_payment;
    }

    public void setId_payment(Long id_payment) {
        this.id_payment = id_payment;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    //*******************************************************
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


