package be.cyimena.airbnb.assetsservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "address_id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String streetNumber;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private RealEstate realEstate;

}
