package de.nordakademie.iaa.RidingClub.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by luisiglesias on 23/10/15.
 */


@Entity
@Table(name = "Payments")
public class Payments implements  Serializable{


       // private static final long serialVersionUID = 6925248180274039273L;

        private Long id;

        private String memberType;

        private int year;

        private float amount;

        private Boolean status;

        private Member member;


        //***************************************************************************************
        //ID:
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        //*******************************************************
        // Member Type:
        //@Column(nullable = false)
        public String getMemberType() {
            return memberType;
        }

        public void setMemberType(String memberType) {
            this.memberType = memberType;
        }

        //*******************************************************
        // Year:
        //@Column(nullable = false)
        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        //*******************************************************
        // Amount:
        @Column(nullable = false)
        public float getAmount() {
            return amount;
        }

        public void setAmount(float amount) {
            this.amount = amount;
        }

        //*******************************************************
        // Status:
        //@Column(nullable = false)
        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
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


