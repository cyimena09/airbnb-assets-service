package be.cyimena.airbnbassetsservice.services;

import be.cyimena.airbnbassetsservice.models.RealEstate;

import java.util.List;

public interface IRealEstateService {

    List<RealEstate> getRealEstates();

    RealEstate getRealEstateById(Integer realEstateId);

    RealEstate createRealEstate(RealEstate realEstate);

    RealEstate updateRealEstate(RealEstate realEstate);

    void deleteRealEstate(Integer realEstateId);

}

