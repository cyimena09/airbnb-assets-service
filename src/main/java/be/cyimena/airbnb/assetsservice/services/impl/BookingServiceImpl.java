package be.cyimena.airbnb.assetsservice.services.impl;

import be.cyimena.airbnb.assetsservice.mappers.IBookingMapper;
import be.cyimena.airbnb.assetsservice.repositories.BookingRepository;
import be.cyimena.airbnb.assetsservice.services.IBookingService;
import be.cyimena.airbnb.assetsservice.web.models.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    public BookingDto getBookingById(UUID bookingId) {
        return null;
    }

    @Override
    public Page<BookingDto> getBookingsByUserId(UUID bookingId, Pageable pageable) {
        return bookingRepository.findByUserId(bookingId, pageable).map(bookingMapper.INSTANCE::mapToBookingDto);
    }

    @Override
    public void createBooking(BookingDto bookingDto) {
        this.bookingRepository.save(this.bookingMapper.INSTANCE.mapToBooking(bookingDto));
    }

    @Override
    public void updateBooking(BookingDto bookingDto) {

    }
}
