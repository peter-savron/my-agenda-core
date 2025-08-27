package si.savron.apis.dev;

import io.quarkus.arc.profile.IfBuildProfile;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import si.savron.dtos.activeuser.ActiveUserPostDto;
import si.savron.mappers.ActiveUserMapper;
import si.savron.models.ActiveUserEntity;
import si.savron.repositories.ActiveUserRepository;

@Path("dev/active-users")
@IfBuildProfile("dev")
public class DevActiveUser {

    @Inject ActiveUserRepository activeUserRepository;
    @Inject ActiveUserMapper activeUserMapper;

    @GET
    @PermitAll
    public Response getAllActiveUsers(){
        return Response.ok(activeUserRepository.listAll()).build();
    }

    @POST
    @PermitAll
    @Transactional
    public Response createActiveUser(ActiveUserPostDto activeUserPostDto){
        ActiveUserEntity newUser = new ActiveUserEntity();
        newUser.username = activeUserPostDto.username();
        activeUserRepository.persist(newUser);
        return Response.ok(activeUserMapper.toDto(newUser)).build();
    }

}
