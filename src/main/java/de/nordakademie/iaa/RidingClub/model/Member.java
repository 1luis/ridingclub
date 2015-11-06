package de.nordakademie.iaa.RidingClub.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Marc & Luis
 */

@Entity
@Table(name = "member")
public class Member implements  Serializable{

    private static final long serialVersionUID = 6925248180274039273L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@OneToMany
    //@JoinColumn( name = "member_id")
    private Long member_id;

    @Column ( name = "active")
    private Boolean active;

    @Column( name = "name")
    private String name;

    @Column( name = "surname")
    private String surname;

    @Column( name = "address")
    private String address;

    @Column( name = "city")
    private String city;

    @Column( name = "zipcode")
    private String zipcode;

    @Column( name = "iban")
    private String iban;

    @Column( name = "entryDate")
    private String entryDate;

    @Column( name = "exitDate")
    private String exitDate;

    @Column( name = "noticeDate")
    private String noticeDate;

    @Column( name = "birthday")
    private String birthday;

    @Column( name = "memberType")
    private String memberType;

    @Column (name = "familyMember")
    private boolean familyMember;

    /**
     * Getters and Setters
     * @return
     */

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    //@Column(nullable = true)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String Birthday) {
        this.birthday = Birthday;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public boolean getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(boolean familyMember) {
        this.familyMember = familyMember;
    }

}
