package be.cyimena.airbnb.assetsservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "booking_id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp endDate;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "realestate_id")
    private RealEstate realEstate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //private Integer rating;

}
