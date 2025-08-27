package si.savron.dtos.activeuser;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ActiveUserPostDto(
        @NotBlank @Size(max = 63) String username
) {
}
