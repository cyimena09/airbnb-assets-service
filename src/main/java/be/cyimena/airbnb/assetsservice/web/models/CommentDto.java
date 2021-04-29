package be.cyimena.airbnb.assetsservice.web.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table(name = "comment")
public class CommentDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", updatable = false, nullable = false)
    private UUID id;

    private String text;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp createAt;

    @UpdateTimestamp
    private Timestamp updateAt;

    @ManyToOne
    @JoinColumn(name = "realestate_id")
    private RealEstateDto realEstate;

}
