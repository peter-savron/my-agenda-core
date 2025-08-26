package si.savron.exceptionmappers;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import si.savron.exceptionmappers.common.BaseExceptionMapper;
import si.savron.exceptionmappers.errorresponses.ValidationApiErrorList;
import si.savron.exceptionmappers.errorresponses.ValidationError;

import java.util.List;

// TODO do mapping of validation constraints for constraint descriptor
@Provider
public class HibernateValidationExceptionMapper extends BaseExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e){
        List<ValidationError> errors = e.getConstraintViolations().stream()
                .map((constraintViolation -> new ValidationError(
                            constraintViolation.getPropertyPath().toString(),
                            constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName())))
                .toList();
        ValidationApiErrorList apiError = new ValidationApiErrorList(Response.Status.BAD_REQUEST.getStatusCode(),
                "bad.request.validation.failed", "Request has some invalid fields.", errors);
        return Response.status(apiError.status()).entity(apiError).build();
    }
}
