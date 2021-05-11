package be.cyimena.airbnb.assetsservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "category_id", updatable = false, nullable = false)
    private UUID id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<RealEstate> realEstates;

}
