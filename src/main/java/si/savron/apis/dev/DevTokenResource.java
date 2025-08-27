package si.savron.apis.dev;

import io.quarkus.arc.profile.IfBuildProfile;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.Claims;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Path("/dev")
@IfBuildProfile("dev")
public class DevTokenResource {

    // LATER add logic to add additional claims to token

    @GET
    @Path("/generate-token/{userId}")
    @PermitAll
    public Response generateToken(
            @PathParam("userId") UUID userId
    ){
        String token = Jwt.upn(userId.toString())
                .groups(new HashSet<>(List.of("user")))
                .claim(Claims.given_name, "Test user")
                .sign();
        return Response.ok(token).build();
    }
}
