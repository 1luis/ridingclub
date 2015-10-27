package de.nordakademie.iaa.RidingClub.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Payments")
public class Payments implements  Serializable{


        private static final long serialVersionUID = 6925248180274039273L;

        private Long id;

        private MemberType memberType;

        private int year;

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
        @Column(nullable = false)
        public MemberType getMemberType() {
            return memberType;
        }

        public void setMemberType(MemberType memberType) {
            this.memberType = memberType;
        }

        //*******************************************************
        // Year:
        @Column(nullable = false)
        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        //*******************************************************
        // Status:
        @Column(nullable = false)
        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }

        //*******************************************************
        //Member
        //@ManyToOne(fetch = FetchType.EAGER)
        //@JoinColumn(name = "Member", nullable = false)
        @ManyToOne(optional = false)
        public Member getMember(){
            return this.member;

        }

        public void setMember(Member member) {
        this.member = member;

        }


    }


