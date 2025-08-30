package si.savron.models;

import jakarta.persistence.*;
import si.savron.models.common.OwnedEntity;

@Entity
@Table(name = "tags")
public class TagEntity extends OwnedEntity {
    @Column(name = "tag", nullable = false, length = 63)
    public String tag;

    @Column(name = "description", length = 511)
    public String description;
}
