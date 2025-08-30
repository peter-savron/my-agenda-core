package si.savron.dtos.tag;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record TagPutDto(
        @NotNull UUID id,
        @NotBlank @Size(max = 63) String tag,
        @Size(max = 511) String description
) {
}
