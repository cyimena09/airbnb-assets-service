package be.cyimena.airbnb.assetsservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "bookings")
public class Booking {

    // ATTRIBUTES

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "booking_id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "realestate_id")
    private RealEstate realEstate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @Column(columnDefinition = "varchar(255)",  nullable = false)
    private String status;

    private  Integer rating;

}
