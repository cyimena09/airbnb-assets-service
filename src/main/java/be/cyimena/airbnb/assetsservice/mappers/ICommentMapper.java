package be.cyimena.airbnb.assetsservice.mappers;

import be.cyimena.airbnb.assetsservice.domain.Comment;
import be.cyimena.airbnb.assetsservice.web.models.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ICommentMapper {
    ICommentMapper INSTANCE = Mappers.getMapper(ICommentMapper.class);

    Comment mapToComment(CommentDto source);

    CommentDto mapToCommentDto(Comment source);

}
