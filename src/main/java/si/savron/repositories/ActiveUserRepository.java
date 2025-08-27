package si.savron.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import si.savron.models.ActiveUserEntity;
import si.savron.repositories.common.BaseEntityRepository;

@ApplicationScoped
public class ActiveUserRepository extends BaseEntityRepository<ActiveUserEntity> {

}
