package de.nordakademie.iaa.RidingClub.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "member")
public class Member implements  Serializable{

    private static final long serialVersionUID = 6925248180274039273L;


    private Long id;

    @Column( name = "name")
    private String name;

    @Column( name = "surname")
    private String surname;

    @Column( name = "address")
    private String address;

    @Column( name = "city")
    private String city;

/*    @Column( name = "zipcode")
    private String zipcode;*/

    //@OneToMany(mappedBy="member",cascade= CascadeType.ALL)
    @OneToMany
    private Set<Payments> payments;

    //private String iban;

    //TODO: folgende Strings auf Date �ndern sowie Pattern dd-MM-yyyy
    //private String entryDate;
    //private String noticeDate;
    //private String exitDate;
    //private String birthday;

    //private String memberType;

    //**************************************************************

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

/*    // IBAN-Code
    @Column(nullable = true)
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }*/

/*    // Eintrittsdatum
    @Column(nullable = false)
    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }*/

 /*   // K�ndigungsdatum
    @Column(nullable = true)
    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }*/

/*    // Austrittsdatum
    @Column(nullable = true)
    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }*/

/*    // Geburtsdatum
    @Column(nullable = true)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String Birthday) {
        this.birthday = Birthday;
    }*/


   /* // MemberType wird als Referenz gef�hrt??
    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }*/


    public Set<Payments> getPayments() {
        return this.payments;
    }

    public void setPayments(Set<Payments> payments) {
        this.payments = payments;
    }
}
