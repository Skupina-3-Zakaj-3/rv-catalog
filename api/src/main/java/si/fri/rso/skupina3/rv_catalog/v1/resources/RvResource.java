package si.fri.rso.skupina3.rv_catalog.v1.resources;

import si.fri.rso.skupina3.lib.Rv;
import si.fri.rso.skupina3.rv_catalog.services.beans.RvBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/rvs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RvResource {

    private Logger log = Logger.getLogger(RvResource.class.getName());

    @Inject
    private RvBean rvBean;

    @Context
    protected UriInfo uriInfo;

    @GET
    public Response getRv() {

        log.info("getRv() - GET");
        List<Rv> rvs = rvBean.getRv();

        return Response.status(Response.Status.OK).entity(rvs).build();
    }
}
