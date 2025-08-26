package si.savron.dtos.activeuser;

import java.util.UUID;

public record ActiveUserDto(
        UUID id,
        String username
) {
}
