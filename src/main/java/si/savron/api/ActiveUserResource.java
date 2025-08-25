package si.savron.api;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("active-users")
public class ActiveUserResource {
    @Inject
    JsonWebToken jwt;

    // TODO get user from token
    @GET
    @RolesAllowed({"users"})
    public Response getActiveUser(){
        Integer userId = Integer.valueOf(jwt.getSubject());
        // TODO get from database
        return Response.ok(userId).build();
    }

    // TODO update user
    // TODO delete user

    // TODO LATER admin get user with admin requets
}
