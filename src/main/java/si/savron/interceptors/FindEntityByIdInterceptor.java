package si.savron.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.jboss.logging.Logger;
import si.savron.exceptions.EntityNotFoundException;
import si.savron.interceptors.annotations.FindEntityById;
import si.savron.models.common.BaseEntity;

import java.util.UUID;

@FindEntityById
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class FindEntityByIdInterceptor {

    @AroundInvoke
    public Object logResource(InvocationContext context) throws Exception{
        Logger LOG = Logger.getLogger(context.getTarget().getClass());
        if(context.getParameters().length != 1){
            throw new java.lang.IllegalArgumentException("Method has not exactly one argument");
        }
        if(!(context.getParameters()[0] instanceof UUID id)){
            throw new java.lang.IllegalArgumentException("Method has not one argument of type UUID");
        }
        Class<? extends BaseEntity> entityType = context.getMethod().getAnnotation(FindEntityById.class).entityType();
        Object result = context.proceed();
        if (result == null) {
            LOG.trace(STR."\{entityType.getSimpleName()} with id \{id.toString()} not found.");
            throw new EntityNotFoundException("Entity not found", entityType, id);
        }
        return result;
    }
}
