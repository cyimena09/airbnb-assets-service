package be.cyimena.airbnb.assetsservice.mappers;

import be.cyimena.airbnb.assetsservice.domain.Comment;
import be.cyimena.airbnb.assetsservice.web.models.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class})
public interface ICommentMapper {
    ICommentMapper INSTANCE = Mappers.getMapper(ICommentMapper.class);
    @Mapping(target = "realEstate", ignore = true)
    @Mapping(target = "user", ignore = true)
    Comment mapToComment(CommentDto source);

    @Mapping(target = "realEstate", ignore = true)
    @Mapping(target = "user", ignore = true)
    CommentDto mapToCommentDto(Comment source);

}
