package si.savron.interceptors.annotations;

import jakarta.enterprise.util.Nonbinding;
import jakarta.interceptor.InterceptorBinding;
import si.savron.models.common.BaseEntity;

import java.lang.annotation.*;

@InterceptorBinding
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface FindEntityById {
    @Nonbinding Class<? extends BaseEntity> entityType() default BaseEntity.class;
}
