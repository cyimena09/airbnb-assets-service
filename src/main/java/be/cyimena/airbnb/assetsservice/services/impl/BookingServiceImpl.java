package be.cyimena.airbnb.assetsservice.services.impl;

import be.cyimena.airbnb.assetsservice.domain.Booking;
import be.cyimena.airbnb.assetsservice.mappers.IBookingMapper;
import be.cyimena.airbnb.assetsservice.repositories.BookingRepository;
import be.cyimena.airbnb.assetsservice.services.IBookingService;
import be.cyimena.airbnb.assetsservice.web.models.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    BookingRepository bookingRepository;
    IBookingMapper bookingMapper;

    @Override
    public Page<BookingDto> getBookings() {
        return null;
    }

    @Override
    public BookingDto getBookingById(Integer bookingId) {
        return null;
    }

    @Override
    public void createBooking(BookingDto bookingDto) {
        Booking booking = this.bookingMapper.INSTANCE.mapToBooking(bookingDto);
        this.bookingRepository.save(this.bookingMapper.INSTANCE.mapToBooking(bookingDto));
    }

    @Override
    public void updateBooking(BookingDto bookingDto) {

    }
}
