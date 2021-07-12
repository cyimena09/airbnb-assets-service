package be.cyimena.airbnb.assetsservice.mappers;

import be.cyimena.airbnb.assetsservice.domain.RealEstate;
import be.cyimena.airbnb.assetsservice.web.models.RealEstateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {IAddressMapper.class, IUserMapper.class})
public interface IRealEstateMapper {
    IRealEstateMapper INSTANCE = Mappers.getMapper(IRealEstateMapper.class);

    @Mapping(target = "bookings", ignore = true)
    RealEstate mapToRealEstate(RealEstateDto source);

    @Mapping(target = "bookings", ignore = true)
    RealEstateDto mapToRealEstateDto(RealEstate source);

}
