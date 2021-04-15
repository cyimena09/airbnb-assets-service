package be.cyimena.airbnb.assetsservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
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
    Set<Booking> bookings;

}

