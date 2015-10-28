package de.nordakademie.iaa.RidingClub.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Member")
public class Member implements  Serializable{

    private static final long serialVersionUID = 6925248180274039273L;

    private Long id;

    private String name;

    private String surname;

    private Set<Payments> payments;


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

    //One to many
    //@OneToMany(mappedBy="member",cascade= CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "member")
    public Set<Payments> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payments> payments) {
        this.payments = payments;
    }

}
