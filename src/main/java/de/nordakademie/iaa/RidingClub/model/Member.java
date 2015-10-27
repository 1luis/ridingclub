package de.nordakademie.iaa.RidingClub.model;

/**
 * Created by luisiglesias on 21/10/15.
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Member", uniqueConstraints = @UniqueConstraint(columnNames = {"IBAN"}))
public class Member implements  Serializable{

    private static final long serialVersionUID = 6925248180274039273L;

    private Long id;

    private String name;

    private String surname;

    private String city;

    private String address;

    private String zipcode;

    private Date birthday;

    private Date entryDate;

    private Boolean familyMembers;

    private  String IBAN;

    private MemberType memberType;


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
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    //*******************************************************
    // Birthday of the member:
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
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
    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    //***********************************************************************************************
    // Family members?
    @Column(nullable = false)
    public Boolean getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Boolean familyMembers) {
        this.familyMembers = familyMembers;
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

    //*******************************************************
    // Member Type:
    @ManyToOne(optional = false)
    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

}
