package si.savron.api.dev;

import io.quarkus.arc.profile.IfBuildProfile;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.Claims;

import java.util.Arrays;
import java.util.HashSet;

@Path("/dev")
@IfBuildProfile("dev")
public class DevTokenResource {

    // TODO add logic to retrieve customizable tokens, POST request, with parameters
    @GET
    @Path("/generate-token")
    @PermitAll
    public Response generateToken(){
        String token = Jwt.upn("test@savron.si")
                .groups(new HashSet<>(Arrays.asList("user", "admin")))
                .claim(Claims.given_name, "Test")
                .sign();
        return Response.ok(token).build();
    }
}
