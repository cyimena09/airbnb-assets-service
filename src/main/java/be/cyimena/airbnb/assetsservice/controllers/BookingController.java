package be.cyimena.airbnb.assetsservice.controllers;

import be.cyimena.airbnb.assetsservice.exceptions.BookingNotFoundException;
import be.cyimena.airbnb.assetsservice.repositories.BookingRepository;
import be.cyimena.airbnb.assetsservice.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/api/v1")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/bookings/{id}")
    public Booking getBooking(@PathVariable Integer id) {
        return bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
    }

    @GetMapping("/bookings")
    public Page<Booking> getBookings(Pageable pageable){
        return bookingRepository.findAll(pageable);
    }

    @GetMapping("/users/{id}/bookings")
    public Page<Booking> getAllBookingsByUser(@PathVariable Integer id, Pageable pageable) {
        return this.bookingRepository.findByUserId(id, pageable);
    }

    @GetMapping("/realestates/{id}/bookings")
    public Page<Booking> getAllBookingsByRealEstate(@PathVariable Integer id, Pageable pageable) {
        return this.bookingRepository.findByRealEstateId(id, pageable);
    }

    @PostMapping("/bookings")
    public ResponseEntity<String> createBooking(@RequestBody Booking booking, Pageable pageable) {
        LocalDateTime startDate = booking.getStartDate();
        LocalDateTime endDate = booking.getEndDate();

        // check if a reservation for this date exist
        if (this.bookingRepository.
                // rewrite this line
                        findAllByStartDateBetweenOrEndDateBetweenOrStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate,
                        endDate, startDate, endDate, startDate, endDate, pageable).isEmpty()) {

            // add finish status
            booking.setStatus("active");
            booking.setRating(0);
            this.bookingRepository.save(booking);
            return new ResponseEntity<String>(HttpStatus.CREATED);

        } else {
            return new ResponseEntity<String>("This date has already been reserved", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/bookings/{id}")
    public Booking updateBooking(@PathVariable Integer id) {
        // instead of deleting we add the canceled status
        return bookingRepository.findById(id).map(b -> {
            b.setStatus("cancelled");
            return bookingRepository.save(b);
        }).orElseThrow(() -> new BookingNotFoundException(id));
    }

}
