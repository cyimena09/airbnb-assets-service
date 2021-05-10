package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.web.models.BookingDto;
import org.springframework.data.domain.Page;

public interface IBookingService {

    Page<BookingDto> getBookings();

    BookingDto getBookingById(Integer realEstateId);

    void createBooking(BookingDto realEstate);

    void updateBooking(BookingDto realEstate);

}
