package de.nordakademie.iaa.RidingClub.model;

/**
 * Created by luisiglesias on 21/10/15.
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Member", uniqueConstraints = @UniqueConstraint(columnNames = {"IBAN"}))
public class Member implements  Serializable{

   // private static final long serialVersionUID = 6925248180274039273L;

    private Long id;

    private String name;

    private String surname;

    private String city;

    private String address;

    private Long zipcode;

    private Date birthday;

    private String entry_date;

    private Boolean familiy_members;

    private  String IBAN;

    private Set<Payments> Payments;

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
    // Name of the member:
    @Column( nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //*******************************************************
    // Surname of the member:
    @Column(nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //*******************************************************
    // City of the member:
    @Column(nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //*******************************************************
    // Address of the member:
    @Column(nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //*******************************************************
    // Zipcode of the address:
    @Column(nullable = false)
    public Long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }

    //*******************************************************
    // Birthday of the member:
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //**************************************************************************
    // Entry date of the member:
    @Column(nullable = false)
    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    //***********************************************************************************************
    // Family members?
    @Column(nullable = false)
    public Boolean getFamily_members() {
        return familiy_members;
    }

    public void setFamily_members(Boolean familiy_members) {
        this.familiy_members = familiy_members;
    }

    //***********************************************************************************************
    // IBAN:
    @Column(nullable = false)
    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN  ) {
        this.IBAN = IBAN;
    }


    //*************************************************************
    //One to many
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "member")
    public Set<Payments> getPayments(){
        return this.Payments;
    }

    public void setPayments(Set<Payments> Payments){
        this.Payments = Payments;
    }

}
