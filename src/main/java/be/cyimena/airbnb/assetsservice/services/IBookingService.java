package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.web.models.BookingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IBookingService {

    Page<BookingDto> getBookings();

    BookingDto getBookingById(UUID realEstateId);

    Page<BookingDto> getBookingsByUserId(UUID id, Pageable pageable);

    void createBooking(BookingDto realEstate);

    void updateBooking(BookingDto realEstate);

}
