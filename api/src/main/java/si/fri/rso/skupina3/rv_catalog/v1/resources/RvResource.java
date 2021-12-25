package si.fri.rso.skupina3.rv_catalog.v1.resources;

import si.fri.rso.skupina3.lib.Rv;
import si.fri.rso.skupina3.rv_catalog.services.beans.RvBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
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
    public Response getRvs() {

        log.info("getRvs() - GET");
        List<Rv> rvs = rvBean.getRvs(uriInfo);

        return Response.status(Response.Status.OK).entity(rvs).build();
    }

    @GET
    @Path("{id}")
    public Response getRv(@PathParam("id") Integer id) {

        log.info("getRv() - GET");

        Rv rv = rvBean.getRv(id);

        if(rv == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(rv).build();
    }

    @POST
    public Response createRv(Rv rv) {

        log.info("createRv() - POST");

        // TODO: check for needed parameters and send back bad request if they are not present
        if (rv.getDescription() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else {
            rv = rvBean.createRv(rv);
        }

        return Response.status(Response.Status.OK).entity(rv).build();

    }

    @PUT
    @Path("{rvId}")
    public Response putRv(@PathParam("rvId") Integer rvId, Rv rv) {

        log.info("putRv() - PUT");

        rv = rvBean.updateRv(rvId, rv);

        if (rv == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(rv).build();

    }

    @DELETE
    @Path("{rvId}")
    public Response deleteRv(@PathParam("rvId") Integer rvId) {

        log.info("deleteRv() - DELETE");

        boolean deleted = rvBean.deleteRv(rvId);

        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
