package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

@Path("/user")
public class UserResource {

    @GET
    @Path("/profile")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserProfile() {
        UserProfile profile = new UserProfile("John Doe", "john.doe@example.com", 30);
        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(profile);
        return Response.ok(json).build();
    }

    public static class UserProfile {
        public String name;
        public String email;
        public int age;

        public UserProfile(String name, String email, int age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }
    }
}
