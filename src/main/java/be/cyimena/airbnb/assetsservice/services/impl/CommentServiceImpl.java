package be.cyimena.airbnb.assetsservice.services.impl;

import be.cyimena.airbnb.assetsservice.exceptions.CommentNotFoundException;
import be.cyimena.airbnb.assetsservice.mappers.ICommentMapper;
import be.cyimena.airbnb.assetsservice.repositories.CommentRepository;
import be.cyimena.airbnb.assetsservice.services.ICommentService;
import be.cyimena.airbnb.assetsservice.web.models.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    CommentRepository commentRepository;
    ICommentMapper commentMapper;

    @Override
    public Page<CommentDto> getCommentsByRealEstateId(UUID realEstateId) {
        // TODO il faudrait ne pas récupérer le real estate associé
        //return commentRepository.findCommentsByRealEstateId(realEstateId, Sort.by(Sort.Direction.DESC, "updateAt"));
        return null;
    }

    @Override
    public void addComment(CommentDto commentDto) {
        this.commentRepository.save(commentMapper.INSTANCE.mapToComment(commentDto));
    }

    @Override
    public void updateComment(CommentDto commentDto) {
        commentRepository.findById(commentDto.getId()).map(c -> {
            c.setText(commentDto.getText());
            return commentRepository.save(c);
        }).orElseThrow(() -> new CommentNotFoundException(commentDto.getId()));
    }

    @Override
    public void deleteComment(UUID id) {
        commentRepository.findById(id).map(t -> {
            commentRepository.delete(t);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new CommentNotFoundException(id));
    }

}
