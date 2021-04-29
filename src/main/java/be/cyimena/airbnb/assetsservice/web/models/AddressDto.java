package be.cyimena.airbnb.assetsservice.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "address")
public class AddressDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private UUID id;

    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private Integer streetNumber;
    @Column(nullable = false)
    private Long PostalCode;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private RealEstateDto user;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private RealEstateDto realEstate;

}
