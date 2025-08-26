package si.savron.exceptionmappers.errorresponses;

import java.util.List;

public record ValidationApiErrorList(
        Integer status,
        String code,
        String message,
        List<ValidationError> errors
){
}
