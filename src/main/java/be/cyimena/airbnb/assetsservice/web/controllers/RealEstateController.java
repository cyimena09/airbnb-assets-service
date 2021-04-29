package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.repositories.RealEstateRepository;
import be.cyimena.airbnb.assetsservice.exceptions.RealEstateNotFoundException;
import be.cyimena.airbnb.assetsservice.web.models.RealEstateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/assets")
public class RealEstateController {

    @Autowired
    private RealEstateRepository realEstateRepository;

    @GetMapping("/real_estates/{id}")
    public RealEstateDto getRealEstateById(@PathVariable Integer id) {
        return realEstateRepository.findById(id).orElseThrow(() -> new RealEstateNotFoundException(id));
    }

    @GetMapping("/real_estates")
    public Page<RealEstateDto> getAllRealEstates(Pageable pageable) {
        return realEstateRepository.findAll(pageable);
    }

    @GetMapping("/real_estates/users/{id}")
    public Page<RealEstateDto> getRealEstatesByUserId(@PathVariable Integer id, Pageable pageable) {
        return realEstateRepository.findRealEstatesByUserId(id, pageable);
    }

    @GetMapping("/real_estates/search")
    public Page<RealEstateDto> getRealEstatesByFiltre(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "bedroom", required = false) Integer bedroom,
            Pageable pageable) {

        return this.realEstateRepository.findRealEstatesByFilter(type, bedroom, price, country, city, pageable);
    }

    @PostMapping("/real_estates")
    public RealEstateDto createRealEstate(@RequestBody RealEstateDto realEstate) {
        return this.realEstateRepository.save(realEstate);
    }

    @PutMapping("real_estates/{id}")
    public RealEstateDto updateRealEstate(@PathVariable Integer id, @RequestBody RealEstateDto realEstate) {
        return realEstateRepository.findById(id).map(r -> {
            r.setName(realEstate.getName());
            r.setPrice(realEstate.getPrice());
            return realEstateRepository.save(r);
        }).orElseThrow(() -> new RealEstateNotFoundException(id));
    }

    @DeleteMapping("real_estates/{id}")
    public ResponseEntity<?> deleteRealEstate(@PathVariable Integer id) {
        return realEstateRepository.findById(id).map(t -> {
            realEstateRepository.delete(t);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new RealEstateNotFoundException(id));
    }

}
