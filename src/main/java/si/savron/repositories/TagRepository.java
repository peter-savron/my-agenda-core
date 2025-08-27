package si.savron.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import si.savron.models.TagEntity;
import si.savron.repositories.common.BaseEntityRepository;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TagRepository extends BaseEntityRepository<TagEntity> {
    public List<TagEntity> findAllByOwner(UUID ownerId){
        return list("owner.id = ?1", ownerId);
    }
}
