package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.web.models.FilterDto;
import be.cyimena.airbnb.assetsservice.web.models.RealEstateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IRealEstateService {

    Page<RealEstateDto> getRealEstates(Pageable pageable);

    RealEstateDto getRealEstateById(UUID realEstateId);

    Page<RealEstateDto> getRealEstatesByFilter(FilterDto filterDto, Pageable pageable);

    Page<RealEstateDto> getRealEstatesByUserId(UUID userId, Pageable pageable);

    void createRealEstate(RealEstateDto realEstate);

    void updateRealEstate(RealEstateDto realEstate);

    void deleteRealEstate(UUID realEstateId);

}
