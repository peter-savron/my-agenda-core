package si.savron.exceptionmappers.common;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import si.savron.exceptionmappers.errorresponses.BaseApiError;

public abstract class BaseExceptionMapper<T extends Throwable> implements ExceptionMapper<T> {
    @Override
    public Response toResponse(T e) {
        BaseApiError apiError = new BaseApiError(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "internal.server.error", e.getMessage());
        return Response.status(apiError.status()).entity(apiError).build();
    }
}
