package si.savron.models.common;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    public UUID id;

    @Column(name = "created_at", nullable = false, updatable = false)
    public Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    public Instant updatedAt;

    @PrePersist
    private void initializeEntity(){
        createdAt=Instant.now();
        updatedAt=Instant.now();
    }

    @PreUpdate
    private void  updateEntity(){
        updatedAt=Instant.now();
    }
}
