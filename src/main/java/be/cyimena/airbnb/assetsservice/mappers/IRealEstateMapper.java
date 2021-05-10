package be.cyimena.airbnb.assetsservice.mappers;

import be.cyimena.airbnb.assetsservice.domain.RealEstate;
import be.cyimena.airbnb.assetsservice.web.models.RealEstateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IRealEstateMapper {
    IRealEstateMapper INSTANCE = Mappers.getMapper(IRealEstateMapper.class);

    RealEstate mapToRealEstate(RealEstateDto source);

    RealEstateDto mapToRealEstateDto(RealEstate source);

}
