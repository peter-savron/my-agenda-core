package si.savron.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import si.savron.models.ActiveUserEntity;

import java.util.UUID;

@ApplicationScoped
public class ActiveUserRepository implements PanacheRepositoryBase<ActiveUserEntity, UUID> {

}
