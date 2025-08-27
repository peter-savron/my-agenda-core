package si.savron.exceptionmappers.errorresponses;

public record BaseApiError(
        Integer status,
        String code,
        String message
) {
}
