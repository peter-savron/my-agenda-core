package si.savron.exceptions;

import si.savron.models.common.BaseEntity;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {
    private final Class<? extends BaseEntity> entity;
    private final UUID entityId;

    public EntityNotFoundException(String message, Class<? extends BaseEntity> entity, UUID entityId) {
        super(message);
        this.entity = entity;
        this.entityId = entityId;
    }

    public Class<? extends BaseEntity> getEntity() {
        return entity;
    }

    public UUID getEntityId() {
        return entityId;
    }
}
