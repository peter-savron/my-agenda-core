package si.savron.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import si.savron.dtos.activeuser.ActiveUserDto;
import si.savron.models.ActiveUserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface ActiveUserMapper {
    @Mapping(target = "id", source = "user.id")
    ActiveUserDto toDto(ActiveUserEntity user);
}
