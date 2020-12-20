package ashcheulov.mr.api;

import ashcheulov.mr.dao.DAO;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("api")
public class API {

    @Inject
    DAO dao;

    @GET
    @Path("messages")
    public Response getMessages() {
        return Response.ok(dao.getMessages()).build();
    }

    @POST
    @Path("message")
    public Response setMessage(JsonObject message) {
        dao.setMessage(message);
        return Response.ok().build();
    }
}
