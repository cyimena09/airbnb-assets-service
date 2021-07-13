package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.web.models.CommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ICommentService {

    Page<CommentDto> getCommentsByRealEstateId(UUID realEstateId, Pageable pageable);

    void createComment(CommentDto commentDto);

    void updateComment(CommentDto commentDto);

    void deleteComment(UUID id);

}
