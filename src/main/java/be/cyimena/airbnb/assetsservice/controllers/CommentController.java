package be.cyimena.airbnb.assetsservice.controllers;

import be.cyimena.airbnb.assetsservice.exceptions.CommentNotFoundException;
import be.cyimena.airbnb.assetsservice.models.Comment;
import be.cyimena.airbnb.assetsservice.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/assets")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/comments/{realEstateId}")
    public List<Comment> getCommentsByRealEstate(@PathVariable Integer realEstateId) {
        // TODO il faudrait ne pas récupérer le real estate associé
        return commentRepository.findCommentsByRealEstateId(realEstateId, Sort.by(Sort.Direction.DESC, "updateAt"));
    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment) {
        return this.commentRepository.save(comment);
    }

    @PutMapping("comments/{id}")
    public Comment updateComment(@PathVariable Integer id, @RequestBody Comment comment) {
        return commentRepository.findById(id).map(c -> {
            c.setText(comment.getText());
            return commentRepository.save(c);
        }).orElseThrow(() -> new CommentNotFoundException(id));
    }

    @DeleteMapping("comments/{id}")
    public ResponseEntity<?> deleteRealEstate(@PathVariable Integer id) {
        return commentRepository.findById(id).map(t -> {
            commentRepository.delete(t);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new CommentNotFoundException(id));
    }

}
