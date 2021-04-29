package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.web.models.RealEstateDto;

import java.util.List;

public interface IRealEstateService {

    List<RealEstateDto> getRealEstates();

    RealEstateDto getRealEstateById(Integer realEstateId);

    RealEstateDto createRealEstate(RealEstateDto realEstate);

    RealEstateDto updateRealEstate(RealEstateDto realEstate);

    void deleteRealEstate(Integer realEstateId);

}

