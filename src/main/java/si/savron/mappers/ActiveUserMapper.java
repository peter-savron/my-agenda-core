package si.savron.mappers;

import org.mapstruct.Mapper;
import si.savron.dtos.activeuser.ActiveUserDto;
import si.savron.dtos.activeuser.ActiveUserPostDto;
import si.savron.mappers.common.BaseMapper;
import si.savron.mappers.config.MapstructConfig;
import si.savron.models.ActiveUserEntity;

@Mapper(config = MapstructConfig.class)
public interface ActiveUserMapper extends BaseMapper<ActiveUserDto, ActiveUserEntity, ActiveUserPostDto> {
}
