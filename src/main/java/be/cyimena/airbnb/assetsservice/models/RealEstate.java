package be.cyimena.airbnb.assetsservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "realestates")
public class RealEstate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "realestate_id", updatable = false, nullable = false)
    private UUID id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String name;

    private String type;

    private String description;

    private Integer bedroom;

    private Boolean garden;

    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "realEstate")
    Set<Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "realEstate")
    Set<Booking> bookings;

}
