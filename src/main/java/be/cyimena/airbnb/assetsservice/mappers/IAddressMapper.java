package be.cyimena.airbnb.assetsservice.mappers;

import be.cyimena.airbnb.assetsservice.domain.Address;
import be.cyimena.airbnb.assetsservice.web.models.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IAddressMapper {
    IAddressMapper INSTANCE = Mappers.getMapper(IAddressMapper.class);

    @Mapping(target = "realEstate", ignore = true)
    @Mapping(target = "user", ignore = true)
    Address mapToAddress(AddressDto source);

    @Mapping(target = "realEstate", ignore = true)
    @Mapping(target = "user", ignore = true)
    AddressDto mapToAddressDto(Address source);

}
