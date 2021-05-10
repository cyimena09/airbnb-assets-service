package be.cyimena.airbnb.assetsservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(generator = "UUID")
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
    private RealEstate user;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private RealEstate realEstate;

}
