package com.imonit;


import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sort")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SortResource {

    @POST
    @Timed
    public Response sortIntegers(List listToSort) {
        List sortedList = new Sorter().sort(listToSort);
        return Response.ok(sortedList).build();
    }
}
