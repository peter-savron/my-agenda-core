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
}
