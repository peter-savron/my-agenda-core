package si.savron.exceptionmappers.errorresponses;

public record ValidationError(
        String field,
        String type
) {
}
