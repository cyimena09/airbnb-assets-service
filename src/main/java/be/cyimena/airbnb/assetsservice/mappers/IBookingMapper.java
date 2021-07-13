package be.cyimena.airbnb.assetsservice.mappers;

import be.cyimena.airbnb.assetsservice.domain.Booking;
import be.cyimena.airbnb.assetsservice.web.models.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, IRealEstateMapper.class})
public interface IBookingMapper {
    IBookingMapper INSTANCE = Mappers.getMapper(IBookingMapper.class);

    @Mapping(target = "user", ignore = true)
    Booking mapToBooking(BookingDto source);

    @Mapping(target = "user", ignore = true)
    BookingDto mapToBookingDto(Booking source);

}
