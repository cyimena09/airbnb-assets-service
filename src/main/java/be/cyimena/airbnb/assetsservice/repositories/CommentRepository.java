package be.cyimena.airbnb.assetsservice.repositories;

import be.cyimena.airbnb.assetsservice.web.models.CommentDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentDto, Integer> {

    List<CommentDto> findCommentsByRealEstateId(Integer id, Sort sort);

}
