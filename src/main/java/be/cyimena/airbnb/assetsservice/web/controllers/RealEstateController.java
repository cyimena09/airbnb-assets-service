package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.services.IRealEstateService;
import be.cyimena.airbnb.assetsservice.web.models.RealEstateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/assets")
public class RealEstateController {

    @Autowired
    private IRealEstateService realEstateService;

    @GetMapping("/real_estates/{id}")
    public RealEstateDto getRealEstateById(@PathVariable UUID id) {
        return this.realEstateService.getRealEstateById(id);
    }

    @GetMapping("/real_estates")
    public Page<RealEstateDto> getRealEstates(Pageable pageable) {
        return this.realEstateService.getRealEstates(pageable);
    }

    @GetMapping("/real_estates/users/{id}")
    public Page<RealEstateDto> getRealEstatesByUserId(@PathVariable UUID id, Pageable pageable) {
        return this.realEstateService.getRealEstatesByUserId(id, pageable);
    }

    @GetMapping("/real_estates/search")
    public Page<RealEstateDto> getRealEstatesByFilter(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "bedroom", required = false) Integer bedroom,
            Pageable pageable) {

        return this.realEstateService.getRealEstatesByFilter(type, country, city, price, bedroom, pageable);
    }

    @PostMapping("/real_estates")
    public void createRealEstate(@RequestBody RealEstateDto realEstate) {
        this.realEstateService.createRealEstate(realEstate);
    }

    @PutMapping("real_estates")
    public void updateRealEstate(@RequestBody RealEstateDto realEstate) {
        this.realEstateService.updateRealEstate(realEstate);
    }

    @DeleteMapping("real_estates/{id}")
    public void deleteRealEstate(@PathVariable UUID id) {
        this.realEstateService.deleteRealEstate(id);
    }

}
