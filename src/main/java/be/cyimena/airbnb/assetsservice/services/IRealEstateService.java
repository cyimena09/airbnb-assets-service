package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.models.RealEstate;

import java.util.List;

public interface IRealEstateService {

    List<RealEstate> getRealEstates();

    RealEstate getRealEstateById(Integer realEstateId);

    RealEstate createRealEstate(RealEstate realEstate);

    RealEstate updateRealEstate(RealEstate realEstate);

    void deleteRealEstate(Integer realEstateId);

}

