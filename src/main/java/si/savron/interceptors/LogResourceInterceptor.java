package si.savron.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.jboss.logging.Logger;
import si.savron.interceptors.annotations.LogResource;

@LogResource
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class LogResourceInterceptor {
    @Inject ObjectMapper objectMapper;

    @AroundInvoke
    public Object logResource(InvocationContext context) throws Exception{
        Logger logger = Logger.getLogger(context.getTarget().getClass());
        String jsonParameters =  objectMapper.writeValueAsString(context.getParameters());
        logger.trace(STR."Entering method \{context.getTarget().getClass().getSimpleName()}\{context.getMethod().getName()} with parameters: \{jsonParameters}");
        Object result = context.proceed();
        String jsonResult = objectMapper.writeValueAsString(result);
        logger.trace(STR."Exiting reource \{context.getTarget().getClass().getSimpleName()}.\{context.getMethod().getName()} returning: \{jsonResult}");
        return result;
    }
}
