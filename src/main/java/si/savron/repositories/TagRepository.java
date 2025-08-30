package si.savron.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import si.savron.models.TagEntity;
import si.savron.repositories.common.OwnedEntityRepository;

@ApplicationScoped
public class TagRepository implements OwnedEntityRepository<TagEntity> {
    @Override
    public String entityName() {
        return TagEntity.class.getSimpleName();
    }

    @Override
    public String fromStatement() {
        return STR."from \{entityName()} e ";
    }
}
