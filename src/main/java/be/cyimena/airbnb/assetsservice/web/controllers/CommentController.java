package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.services.ICommentService;
import be.cyimena.airbnb.assetsservice.web.models.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/assets")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/comments/{realEstateId}")
    public Page<CommentDto> getCommentsByRealEstate(@PathVariable UUID realEstateId) {
        return this.commentService.getCommentsByRealEstateId(realEstateId);
    }

    @PostMapping("/comments")
    public void addComment(@RequestBody CommentDto comment) {
        this.commentService.addComment(comment);
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
