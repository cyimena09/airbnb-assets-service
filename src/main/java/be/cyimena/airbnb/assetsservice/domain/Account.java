package be.cyimena.airbnb.assetsservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class Account implements Serializable {
    @Id
    @Column(name = "user_id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    private User user;

}
