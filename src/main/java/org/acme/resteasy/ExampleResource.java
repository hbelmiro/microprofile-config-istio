package org.acme.resteasy;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/resteasy/hello")
public class ExampleResource {

    @Inject
    @ConfigProperty(name = "example.language-string")
    Optional<String> language;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        switch (this.language.orElse("en")) {
            case "pt":
                return "Olá";
            case "it":
                return "Ciao";
            default:
                return "Hello";
        }
    }
}