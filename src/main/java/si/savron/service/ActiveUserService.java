package si.savron.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import si.savron.dtos.activeuser.ActiveUserDto;
import si.savron.interceptors.annotations.FindEntityById;
import si.savron.mappers.ActiveUserMapper;
import si.savron.models.ActiveUserEntity;
import si.savron.repositories.ActiveUserRepository;

import java.util.UUID;

@ApplicationScoped
public class ActiveUserService {
    @Inject ActiveUserRepository activeUserRepository;
    @Inject ActiveUserMapper activeUserMapper;

    @FindEntityById(entityType = ActiveUserEntity.class)
    public ActiveUserDto getUserById(UUID id){
        return activeUserMapper.toDto(activeUserRepository.findById(id));
    }
}
