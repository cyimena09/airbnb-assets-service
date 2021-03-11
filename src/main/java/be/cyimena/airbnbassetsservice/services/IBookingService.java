package be.cyimena.airbnbassetsservice.services;

import be.cyimena.airbnbassetsservice.models.Booking;

import java.util.List;

public interface IBookingService {

    List<Booking> getBookings();

    Booking getBookingById(Integer realEstateId);

    Booking createBooking(Booking realEstate);

    Booking updateBooking(Booking realEstate);

}
