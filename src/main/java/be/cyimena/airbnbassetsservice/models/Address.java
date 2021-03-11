package be.cyimena.airbnbassetsservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    // ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer id;

    private String street;

    private Integer streetNumber;

    private Long PostalCode;

    private String city;

    private String country;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private RealEstate user;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private RealEstate realEstate;

    // METHODS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Long getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(Long postalCode) {
        PostalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public RealEstate getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(RealEstate realEstate) {
        this.realEstate = realEstate;
    }

    public RealEstate getUser() {
        return user;
    }

    public void setUser(RealEstate user) {
        this.user = user;
    }

}
