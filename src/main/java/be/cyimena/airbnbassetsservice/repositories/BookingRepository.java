package be.cyimena.airbnbassetsservice.repositories;

import be.cyimena.airbnbassetsservice.models.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Page<Booking> findByUserId(Integer id, Pageable pageable);

    Page<Booking> findByRealEstateId(Integer id, Pageable pageable);

    // used for check if a reservation exist
    // find one il y a une erreur
    Page<Booking> findAllByStartDateBetweenOrEndDateBetweenOrStartDateLessThanEqualAndEndDateGreaterThanEqual(
            LocalDateTime startDateMin,
            LocalDateTime startDateMax,
            LocalDateTime endDateMin,
            LocalDateTime endDateMax,
            LocalDateTime endDateMin1,
            LocalDateTime endDateMax2,
            Pageable pageable);

}