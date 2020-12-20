package ashcheulov.mr;

import ashcheulov.mr.dao.DAO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public class IndexController {

    @GET
    @Produces("text/html")
    public Response getIndexPage() {
        return Response.ok().build();
    }
}
