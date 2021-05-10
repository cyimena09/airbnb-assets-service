package be.cyimena.airbnb.assetsservice.mappers;

import be.cyimena.airbnb.assetsservice.domain.Booking;
import be.cyimena.airbnb.assetsservice.web.models.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IBookingMapper {
    IBookingMapper INSTANCE = Mappers.getMapper(IBookingMapper.class);

    Booking mapToBooking(BookingDto source);

    BookingDto mapToFBookingDto(Booking source);

}
