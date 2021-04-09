package be.cyimena.airbnb.assetsservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "realestates")
public class RealEstate implements Serializable {

    // ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "realestate_id", updatable = false, nullable = false)
    private Integer id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String name;

    private String type;

    private String description;

    private Integer bedroom;

    private Boolean garden;

    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "realEstate")
    Set<Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "realEstate")
    Set<Booking> bookings;

    // METHODS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String label) {
        this.name = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }

    public Boolean getGarden() {
        return garden;
    }

    public void setGarden(Boolean garden) {
        this.garden = garden;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
