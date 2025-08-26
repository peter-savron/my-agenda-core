package si.savron.exceptionmappers.errorresponses;

public record NotFoundEntityApiError(
        Integer status,
        String code,
        String message,
        String id,
        String entity
) {
}
