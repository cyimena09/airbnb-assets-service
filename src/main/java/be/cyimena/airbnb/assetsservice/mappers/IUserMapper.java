package be.cyimena.airbnb.assetsservice.mappers;

import be.cyimena.airbnb.assetsservice.domain.User;
import be.cyimena.airbnb.assetsservice.web.models.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {IAccountMapper.class, IAddressMapper.class})
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "realEstates", ignore = true)
    User mapToUser(UserDto source);

    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "realEstates", ignore = true)
    UserDto mapToUserDto(User source);

}
