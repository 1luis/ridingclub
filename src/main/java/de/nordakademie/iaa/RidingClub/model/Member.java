package de.nordakademie.iaa.RidingClub.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Member")
public class Member implements  Serializable{

    private static final long serialVersionUID = 6925248180274039273L;

    //id wird als eindeutige Mitgliedsnummer verwendet
    private Long id;

    private String name1;

    private String surname;

    private String address;

    private String city;

    private String zipcode;

    private String iban;

    //TODO: folgende Strings auf Date ändern sowie Pattern dd-MM-yyyy
    private String entryDate;
    private String noticeDate;
    private String exitDate;
    private String birthday;

    private String memberType;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Name of the member:
    @Column( nullable = false)
    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    // Surname of the member:
    @Column(nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // ZIP-Code (PLZ)
    @Column(nullable = false)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    // Adresse
    @Column(nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Wohnort
    @Column(nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // IBAN-Code
    @Column(nullable = true)
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    // Eintrittsdatum
    @Column(nullable = false)
    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    // Kündigungsdatum
    @Column(nullable = true)
    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }

    // Austrittsdatum
    @Column(nullable = true)
    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    // Geburtsdatum
    @Column(nullable = true)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String Birthday) {
        this.birthday = Birthday;
    }


    // MemberType wird als Referenz geführt??
    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

}
