package si.savron.dtos.tag;

import java.util.UUID;

public record TagDto(
        UUID id,
        String tag,
        String description
) {
}
