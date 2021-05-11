package be.cyimena.airbnb.assetsservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "goal_id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "goals")
    private Set<RealEstate> realEstates;

}
