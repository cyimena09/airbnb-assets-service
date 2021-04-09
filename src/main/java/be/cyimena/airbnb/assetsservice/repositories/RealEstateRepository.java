package be.cyimena.airbnb.assetsservice.repositories;

import be.cyimena.airbnb.assetsservice.models.RealEstate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Integer> {

    @Query("SELECT re FROM RealEstate re " +
            "INNER JOIN re.address a " +
            "INNER JOIN re.bookings b " +
            "WHERE (:type is null OR re.type = :type) " +
            "AND (:bedroom is null OR re.bedroom >= :bedroom) " +
            "AND (:price is null OR re.price <= :price) " +
            "AND (:country is null OR a.country = :country) " +
            "AND (:city is null OR a.city = :city) ")
    Page<RealEstate> findRealEstatesByFilter(
            @Param("type") String type,
            @Param("bedroom") Integer bedroom,
            @Param("price") Double price,
            @Param("country") String country,
            @Param("city") String city,
            Pageable pageable);

}
