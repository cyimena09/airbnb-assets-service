package be.cyimena.airbnb.assetsservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "user_id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String firstName;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String lastName;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String phoneNumber;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToMany
    private Set<RealEstate> realEstates;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Booking> bookings;

}

