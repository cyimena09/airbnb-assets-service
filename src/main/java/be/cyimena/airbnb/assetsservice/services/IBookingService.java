package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.web.models.BookingDto;

import java.util.List;

public interface IBookingService {

    List<BookingDto> getBookings();

    BookingDto getBookingById(Integer realEstateId);

    BookingDto createBooking(BookingDto realEstate);

    BookingDto updateBooking(BookingDto realEstate);

}
