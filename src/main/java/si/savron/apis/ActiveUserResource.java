package si.savron.apis;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import si.savron.interceptors.annotations.LogResource;
import si.savron.service.ActiveUserService;

import java.util.UUID;

@Path("active-users")
@LogResource
public class ActiveUserResource {
    @Inject JsonWebToken jwt;
    @Inject ActiveUserService activeUserService;

    @GET
    @Path("/me")
    @RolesAllowed({"user"})
    public Response getActiveUser(){
        UUID userId = UUID.fromString(jwt.getClaim("upn"));

        return Response.ok(
                activeUserService.getUserById(userId)
        ).build();
    }

    // TODO update user

    // TODO delete user - delete account

    // TODO LATER register flow on separate Resource
    // TODO LATER admin get user with admin requets
}
