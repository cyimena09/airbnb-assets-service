package be.cyimena.airbnb.assetsservice.services.impl;

import be.cyimena.airbnb.assetsservice.domain.RealEstate;
import be.cyimena.airbnb.assetsservice.exceptions.RealEstateNotFoundException;
import be.cyimena.airbnb.assetsservice.mappers.IRealEstateMapper;
import be.cyimena.airbnb.assetsservice.repositories.RealEstateRepository;
import be.cyimena.airbnb.assetsservice.services.IRealEstateService;
import be.cyimena.airbnb.assetsservice.web.models.FilterDto;
import be.cyimena.airbnb.assetsservice.web.models.RealEstateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
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
    public Page<RealEstateDto> getRealEstatesByFilter(FilterDto filterDto, Pageable pageable) {
        String category = filterDto.getCategory();
        String type = filterDto.getType();
        Integer minBedroom = filterDto.getMinBedroom();
        Integer maxBedroom = filterDto.getMaxBedroom();
        Double minPrice = filterDto.getMinPrice();
        Double maxPrice = filterDto.getMaxPrice();
        String city = filterDto.getCity();
        String country = filterDto.getCountry();

        return realEstateRepository.findRealEstatesByFilter(category, type, minBedroom, maxBedroom, minPrice, maxPrice, pageable)
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
