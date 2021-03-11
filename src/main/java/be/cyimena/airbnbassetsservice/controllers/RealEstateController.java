package be.cyimena.airbnbassetsservice.controllers;

import be.cyimena.airbnbassetsservice.exceptions.RealEstateNotFoundException;
import be.cyimena.airbnbassetsservice.exceptions.UserNotFoundException;
import be.cyimena.airbnbassetsservice.models.RealEstate;
import be.cyimena.airbnbassetsservice.repositories.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class RealEstateController {

    @Autowired
    private RealEstateRepository realEstateRepository;

    @GetMapping("/realestates/{id}")
    public RealEstate getRealEstate(@PathVariable Integer id) {
        return realEstateRepository.findById(id).orElseThrow(() -> new RealEstateNotFoundException(id));
    }

    @GetMapping("/realestates")
    public Page<RealEstate> getRealEstates(Pageable pageable){
        return realEstateRepository.findAll(pageable);
    }

    @GetMapping("/realestates/search")
    public Page<RealEstate> getRealEstatesByFiltre(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "bedroom", required = false) Integer bedroom,
            Pageable pageable) {

        return this.realEstateRepository.findRealEstatesByFiltre(type, bedroom, price, country, city, pageable);
    }

    @PostMapping("/realestates")
    public RealEstate createRealEstate(@RequestBody RealEstate realEstate) {
        return this.realEstateRepository.save(realEstate);
    }

    @PutMapping("realestates/{id}")
    public RealEstate updateRealEstate(@PathVariable Integer id, @RequestBody RealEstate realEstate) {
        return realEstateRepository.findById(id).map(r -> {
            r.setName(realEstate.getName());
            r.setPrice(realEstate.getPrice());
            return realEstateRepository.save(r);
        }).orElseThrow(() -> new RealEstateNotFoundException(id));
    }

    @DeleteMapping("realestates/{id}")
    public ResponseEntity<?> deleteRealEstate(@PathVariable Integer id) {
        return realEstateRepository.findById(id).map(t -> {
            realEstateRepository.delete(t);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new UserNotFoundException(id));
    }

}
