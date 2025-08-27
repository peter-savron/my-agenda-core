package si.savron.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import si.savron.models.common.BaseEntity;

@Entity(name = "active_users")
public class ActiveUserEntity extends BaseEntity {
    @Column(name = "username", length = 63)
    public String username;
}
