package be.cyimena.airbnb.assetsservice.services.impl;

import be.cyimena.airbnb.assetsservice.domain.Purpose;
import be.cyimena.airbnb.assetsservice.exceptions.RealEstateNotFoundException;
import be.cyimena.airbnb.assetsservice.mappers.IRealEstateMapper;
import be.cyimena.airbnb.assetsservice.repositories.RealEstateRepository;
import be.cyimena.airbnb.assetsservice.services.IRealEstateService;
import be.cyimena.airbnb.assetsservice.web.models.RealEstateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RealEstateServiceImpl implements IRealEstateService {

    @Autowired
    RealEstateRepository realEstateRepository;
    IRealEstateMapper realEstateMapper;

    @Override
    public Page<RealEstateDto> getRealEstates(Pageable pageable) {
        return realEstateRepository.findAll(pageable).map(realEstateMapper.INSTANCE::mapToRealEstateDto);
    }

    @Override
    public RealEstateDto getRealEstateById(UUID realEstateId) {
        return realEstateMapper.INSTANCE.mapToRealEstateDto(realEstateRepository.findById(realEstateId).orElseThrow(() -> {
            throw new RealEstateNotFoundException(realEstateId);
        }));
    }

    @Override
    public Page<RealEstateDto> getRealEstatesByUserId(UUID userId, Pageable pageable) {
        return realEstateRepository.findRealEstatesByUserId(userId, pageable).map(realEstateMapper.INSTANCE::mapToRealEstateDto);
    }

    @Override
    public Page<RealEstateDto> getRealEstatesByFilter(Set<Purpose> purposes, String country, String city, Double price,
                                                      Integer bedroom, Pageable pageable) {

        return realEstateRepository.findRealEstatesByFilter(purposes, bedroom, price, country, city, pageable)
                .map(realEstateMapper.INSTANCE::mapToRealEstateDto);
    }

    @Override
    public void createRealEstate(RealEstateDto realEstate) {
        this.realEstateRepository.save(realEstateMapper.INSTANCE.mapToRealEstate(realEstate));
    }

    @Override
    public void updateRealEstate(RealEstateDto realEstate) {
        realEstateRepository.findById(realEstate.getId()).map(r -> {
            r.setName(realEstate.getName());
            r.setPrice(realEstate.getPrice());
            return realEstateRepository.save(r);
        }).orElseThrow(() -> new RealEstateNotFoundException(realEstate.getId()));
    }

    @Override
    public void deleteRealEstate(UUID realEstateId) {
        realEstateRepository.findById(realEstateId).map(t -> {
            realEstateRepository.delete(t);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new RealEstateNotFoundException(realEstateId));
    }

}
