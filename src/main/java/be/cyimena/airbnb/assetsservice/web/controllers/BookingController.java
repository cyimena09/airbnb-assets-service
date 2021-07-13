package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.services.IBookingService;
import be.cyimena.airbnb.assetsservice.web.models.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/assets")
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    @GetMapping("/bookings/{id}")
    public BookingDto getBookingById(@PathVariable UUID id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/bookings")
    public Page<BookingDto> getBookings(Pageable pageable) {
        return bookingService.getBookings();
    }

    @GetMapping("bookings/users/{id}/bookings")
    public Page<BookingDto> getAllBookingsByUserId(@PathVariable UUID id, Pageable pageable) {
        return this.bookingService.getBookingsByUserId(id, pageable);
    }

    @GetMapping("bookings/real_estates/{id}/bookings")
    public Page<BookingDto> getAllBookingsByRealEstate(@PathVariable UUID id, Pageable pageable) {
        return null;
    }

    @PostMapping("/bookings")
    public ResponseEntity<String> createBooking(@RequestBody BookingDto booking, Pageable pageable) {
        this.bookingService.createBooking(booking);
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
    public void updateBooking(@PathVariable UUID id) {

    }

}
