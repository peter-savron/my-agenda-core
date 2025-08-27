package si.savron.repositories.common;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import si.savron.models.common.BaseEntity;

import java.util.UUID;

public class BaseEntityRepository<E extends BaseEntity> implements PanacheRepositoryBase<E, UUID> {

}
