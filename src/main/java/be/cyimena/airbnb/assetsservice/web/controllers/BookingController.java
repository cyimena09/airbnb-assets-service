package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.exceptions.BookingNotFoundException;
import be.cyimena.airbnb.assetsservice.repositories.BookingRepository;
import be.cyimena.airbnb.assetsservice.services.IBookingService;
import be.cyimena.airbnb.assetsservice.web.models.BookingDto;
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
    private IBookingService bookingService;

    @GetMapping("/bookings/{id}")
    public BookingDto getBookingById(@PathVariable Integer id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/bookings")
    public Page<BookingDto> getBookings(Pageable pageable) {
        return bookingService.getBookings();
    }

    @GetMapping("/users/{id}/bookings")
    public Page<BookingDto> getAllBookingsByUser(@PathVariable Integer id, Pageable pageable) {
        return null;
    }

    @GetMapping("/realestates/{id}/bookings")
    public Page<BookingDto> getAllBookingsByRealEstate(@PathVariable Integer id, Pageable pageable) {
        return null;
    }

    @PostMapping("/bookings")
    public ResponseEntity<String> createBooking(@RequestBody BookingDto booking, Pageable pageable) {


//        LocalDateTime startDate = booking.getStartDate();
//        LocalDateTime endDate = booking.getEndDate();
//
//        // check if a reservation for this date exist
//        if (this.bookingRepository.
//                // rewrite this line
//                        findAllByStartDateBetweenOrEndDateBetweenOrStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate,
//                        endDate, startDate, endDate, startDate, endDate, pageable).isEmpty()) {
//
//            // add finish status
//            booking.setStatus("active");
//            booking.setRating(0);
//            this.bookingRepository.save(booking);
//            return new ResponseEntity<String>(HttpStatus.CREATED);
//
//        } else {
//            return new ResponseEntity<String>("This date has already been reserved", HttpStatus.BAD_REQUEST);
//        }

        return null;
    }

    @PutMapping("/bookings/{id}")
    public void updateBooking(@PathVariable Integer id) {

    }

}
