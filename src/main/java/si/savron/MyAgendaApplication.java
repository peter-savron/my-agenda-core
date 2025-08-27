package si.savron;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
    info = @Info(
        title = "MyAgenda core backend",
        version = "1.0.0",
        description = "Core functionalities and implementation of app.",
        termsOfService = "TO DO add terms of service",
        contact = @Contact(
                name = "Peter Šavron",
                email = "peter.savron03@gmail.com"
        ),
        license = @License(
                name = "TO DO add license"
        )
    )
)
@ApplicationPath("/v1")
public class MyAgendaApplication extends Application {
    // TAGS: add repository, find for user, add for user, update tags, delete tags LATER: share tags, repository->service->resource

    // TODO in abstract class u can initiallize logger in constructor to have this.getClass()

    // TODO phase 1:
    //  activity and diary
    //  tags for activity and diary without profile fk
    //  add steps for activity
    //  add task to group activty
    // TODO phase 2:
    //  person and groups
    //  add people to task and diary
}
