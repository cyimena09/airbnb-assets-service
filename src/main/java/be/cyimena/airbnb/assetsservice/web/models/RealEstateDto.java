package be.cyimena.airbnb.assetsservice.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "realestates")
public class RealEstateDto implements Serializable {

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
    private AddressDto address;

    @ManyToOne
    private UserDto user;

    @JsonIgnore
    @OneToMany(mappedBy = "realEstate")
    Set<CommentDto> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "realEstate")
    Set<BookingDto> bookings;

}
