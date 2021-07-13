package be.cyimena.airbnb.assetsservice.services.impl;

import be.cyimena.airbnb.assetsservice.domain.Comment;
import be.cyimena.airbnb.assetsservice.domain.RealEstate;
import be.cyimena.airbnb.assetsservice.domain.User;
import be.cyimena.airbnb.assetsservice.exceptions.CommentNotFoundException;
import be.cyimena.airbnb.assetsservice.mappers.ICommentMapper;
import be.cyimena.airbnb.assetsservice.repositories.CommentRepository;
import be.cyimena.airbnb.assetsservice.services.ICommentService;
import be.cyimena.airbnb.assetsservice.web.models.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    CommentRepository commentRepository;
    ICommentMapper commentMapper;

    @Override
    public Page<CommentDto> getCommentsByRealEstateId(UUID realEstateId, Pageable pageable) {
        return commentRepository.findCommentsByRealEstateId(realEstateId, pageable).map(commentMapper.INSTANCE::mapToCommentDto);
    }

    @Override
    public void createComment(CommentDto commentDto) {
        User user = new User();
        RealEstate realEstate = new RealEstate();
        user.setId(commentDto.getUser().getId());
        realEstate.setId(commentDto.getRealEstate().getId());
        Comment comment = commentMapper.INSTANCE.mapToComment(commentDto);
        comment.setUser(user);
        comment.setRealEstate(realEstate);
        this.commentRepository.save(comment);
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
