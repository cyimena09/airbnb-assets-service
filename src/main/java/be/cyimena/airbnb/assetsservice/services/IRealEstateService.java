package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.domain.Purpose;
import be.cyimena.airbnb.assetsservice.web.models.RealEstateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;
import java.util.UUID;

public interface IRealEstateService {

    Page<RealEstateDto> getRealEstates(Pageable pageable);

    RealEstateDto getRealEstateById(UUID realEstateId);

    Page<RealEstateDto> getRealEstatesByFilter(Set<Purpose> goals, String country, String city, Double price, Integer bedroom, Pageable pageable);

    Page<RealEstateDto> getRealEstatesByUserId(UUID userId, Pageable pageable);

    void createRealEstate(RealEstateDto realEstate);

    void updateRealEstate(RealEstateDto realEstate);

    void deleteRealEstate(UUID realEstateId);

}

