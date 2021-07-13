package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.services.ICommentService;
import be.cyimena.airbnb.assetsservice.web.models.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/assets")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/comments/{realEstateId}")
    public Page<CommentDto> getCommentsByRealEstateId(@PathVariable UUID realEstateId, Pageable pageable) {
        System.out.println("On récupère les commentaires");
        return this.commentService.getCommentsByRealEstateId(realEstateId, pageable);
    }

    @PostMapping("/comments")
    public void createComment(@RequestBody CommentDto comment) {
        System.out.println("On ajoute un commentaire");
        this.commentService.createComment(comment);
    }

    @PutMapping("comments")
    public void updateComment(@RequestBody CommentDto comment) {
        this.commentService.updateComment(comment);
    }

    @DeleteMapping("comments/{id}")
    public void deleteComment(@PathVariable UUID id) {
        this.commentService.deleteComment(id);
    }

}
