package si.savron.models;

import jakarta.persistence.*;
import org.hibernate.annotations.*;
import si.savron.models.common.BaseEntity;
import si.savron.models.common.OwnedEntity;
import si.savron.models.converters.BaseEntityDiscriminatorStrategy;

import java.util.UUID;

@Entity
@Table(name = "tag_mappings")
public class TagMappingEntity extends OwnedEntity {

    @ManyToOne
    @JoinColumn(name="tag_id", updatable = false, nullable = false)
    TagEntity tag;

    // about use of Any
    // https://docs.jboss.org/hibernate/orm/7.1/introduction/html_single/Hibernate_Introduction.html#any
    @Any(fetch = FetchType.LAZY, optional = false)
    @AnyKeyJavaClass(UUID.class)
    @AnyDiscriminator(value = DiscriminatorType.STRING)
    @AnyDiscriminatorImplicitValues(implementation = BaseEntityDiscriminatorStrategy.class)
    @JoinColumn(name = "target_id", updatable = false, nullable = false)
    @Column(name = "target_type", length = 7, updatable = false, nullable = false)
    private BaseEntity tagged;
}
