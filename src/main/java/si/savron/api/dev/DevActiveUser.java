package si.savron.api.dev;

import io.quarkus.arc.profile.IfBuildProfile;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import si.savron.repositories.ActiveUserRepository;

@Path("dev/active-users")
@IfBuildProfile("dev")
public class DevActiveUser {

    @Inject
    ActiveUserRepository activeUserRepository;

    @GET
    @PermitAll
    public Response getAllActiveUsers(){
        return Response.ok(activeUserRepository.listAll()).build();
    }

    @POST
    @PermitAll
    public Response createActiveUser(){
        // TODO generate user from request body
        return Response.ok().build();
    }

}
