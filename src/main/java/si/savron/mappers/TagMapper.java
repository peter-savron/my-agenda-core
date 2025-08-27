package si.savron.mappers;

import org.jboss.logging.Logger;
import org.mapstruct.Mapper;
import si.savron.dtos.tag.TagDto;
import si.savron.dtos.tag.TagPostDto;
import si.savron.mappers.common.BaseMapper;
import si.savron.mappers.config.MapstructConfig;
import si.savron.models.TagEntity;

@Mapper(config = MapstructConfig.class)
public interface TagMapper extends BaseMapper<TagDto, TagEntity, TagPostDto> {
}
