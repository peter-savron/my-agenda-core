package si.savron.exceptionmappers;

import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import si.savron.exceptionmappers.common.BaseExceptionMapper;
import si.savron.exceptionmappers.errorresponses.NotFoundEntityApiError;
import si.savron.exceptions.EntityNotFoundException;

public class EntityNotFoundExceptionMapper extends BaseExceptionMapper<EntityNotFoundException> {

    private final Logger LOG = Logger.getLogger(EntityNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(EntityNotFoundException e) {
        String id = e.getEntityId().toString();
        String entityName = e.getEntity().getSimpleName().replaceAll("Entity", "");
        LOG.trace(STR."\{entityName} with id \{id} was not found");
        var apiError = new NotFoundEntityApiError(
                Response.Status.NOT_FOUND.getStatusCode(),
                "entity.not.found", STR."\{entityName} with id \{id} was not found",
                id, entityName
        );
        return Response.status(apiError.status()).entity(apiError).build();
    }
}
