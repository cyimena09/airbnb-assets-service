package be.cyimena.airbnb.assetsservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "realestates")
public class RealEstate implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "realestate_id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String name;

    @ManyToOne
    private RealEstateType type; // Villa, Apartment

    @ManyToOne
    private Category category; // Location, Sell

    @Column(columnDefinition = "text")
    private String description;

    private double price;
    private Integer bedroom;
    private Boolean hasGarden;
    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "realEstate")
    private Set<Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "realEstate")
    private Set<Booking> bookings;

    @ManyToOne
    private User user;

    // todo add createaat

}
