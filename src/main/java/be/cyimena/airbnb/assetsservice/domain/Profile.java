package be.cyimena.airbnb.assetsservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "profile_id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)

    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;
}
