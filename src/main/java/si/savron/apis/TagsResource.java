package si.savron.apis;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import si.savron.dtos.tag.TagPostDto;
import si.savron.dtos.tag.TagPutDto;
import si.savron.service.TagService;
import si.savron.utils.UserToken;

import java.util.List;
import java.util.UUID;

@Path("/tags")
@Authenticated
public class TagsResource {
    @Inject UserToken userToken;
    @Inject TagService tagService;

    @GET
    public Response getAllUserTags(){
        return Response.ok(
                tagService.getUserTags(userToken.getUserId()))
                .build();
    }

    @POST
    public Response postTags(@Valid List<TagPostDto> tags){
        return Response.status(Response.Status.CREATED).entity(
                tagService.createTags(tags, userToken.getUserId())
        ).build();
    }

    @PUT
    public Response putTags(@Valid List<TagPutDto> tags){
        return Response.ok(
                tagService.updateTags(tags, userToken.getUserId())
        ).build();
    }

    @DELETE
    public Response deleteTags(List<UUID> ids){
        tagService.deleteTags(ids, userToken.getUserId());
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
