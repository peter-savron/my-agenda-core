package si.savron.models;

import jakarta.persistence.*;
import si.savron.models.common.BaseEntity;

@Entity(name = "tags")
public class TagEntity extends BaseEntity {
    @Column(name = "tag", nullable = false, length = 63)
    public String tag;

    @Column(name = "description", length = 511)
    public String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", updatable = false)
    public ActiveUserEntity owner;
}
