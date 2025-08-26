package si.savron.dtos.activeuser;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record ActiveUserPostDto(
        @NotBlank @Max(63) String username
) {
}
