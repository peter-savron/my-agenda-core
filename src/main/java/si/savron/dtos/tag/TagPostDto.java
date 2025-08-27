package si.savron.dtos.tag;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TagPostDto(
        @NotBlank @Size(max = 63) String tag,
        @Size(max = 511) String description
) {
}
