package be.cyimena.airbnb.assetsservice.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "ratings")
public class Rating implements Serializable {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "rating_id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private Integer stars;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="realEstate_id")
    private RealEstate realEstate;

}
