package be.cyimena.airbnb.assetsservice.repositories;

import be.cyimena.airbnb.assetsservice.domain.RealEstate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, UUID> {

    Page<RealEstate> findRealEstatesByUserId(UUID id, Pageable pageable);

    @Query("SELECT re FROM RealEstate re " +
            "INNER JOIN re.address a " +
            "INNER JOIN re.bookings b " +
            "INNER JOIN re.type t " +
            "INNER JOIN re.category c " +
            "WHERE c.name = :category " +
            "AND t.name = :type " +
            "AND re.bedroom >= :minBedroom AND re.bedroom <= :maxBedroom " +
            "AND re.price >= :minPrice AND re.price <= :maxPrice " +
            "AND a.city = :city " +
            "AND a.country = :country")
    Page<RealEstate> findRealEstatesByFilter(
            @Param("category") String category,
            @Param("type") String type,
            @Param("minBedroom") Integer minBedroom,
            @Param("maxBedroom") Integer maxBedroom,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("city") String city,
            @Param("country") String country,
            Pageable pageable);
}
