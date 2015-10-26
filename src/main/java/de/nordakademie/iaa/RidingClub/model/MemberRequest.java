package de.nordakademie.iaa.RidingClub.model;

import java.util.Date;

/**
 * Created by luisiglesias on 25/10/15.
 */
public class MemberRequest {

    private String name;

    private String surname;

    private String city;

    private String address;

    private Integer zipcode;

    private Date birthday;

    private String entry_date;

    private boolean family_members;

    private String IBAN;

    private MemberType memberType;


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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public boolean isFamily_members() {
        return family_members;
    }

    public void setFamily_members(boolean family_members) {
        this.family_members = family_members;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

}
