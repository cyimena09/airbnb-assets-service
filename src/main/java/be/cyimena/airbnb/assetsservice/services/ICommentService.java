package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.web.models.CommentDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ICommentService {

    Page<CommentDto> getCommentsByRealEstateId(UUID realEstateId);

    void addComment(CommentDto commentDto);

    void updateComment(CommentDto commentDto);

    void deleteComment(UUID id);

}
