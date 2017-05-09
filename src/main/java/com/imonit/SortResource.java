package com.imonit;


import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Path("/sort")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SortResource {
    private Counter counter;

    public SortResource(MetricRegistry metrics, String metricsHost, Integer metricsPort) {
        counter = metrics.counter("sortCounter");

        Graphite graphite = new Graphite(new InetSocketAddress(metricsHost, metricsPort));
        GraphiteReporter reporter = GraphiteReporter.forRegistry(metrics).filter(MetricFilter.ALL).build(graphite);
        reporter.start(1, TimeUnit.SECONDS);
    }

    @POST
    @Timed
    public Response sortIntegers(List listToSort) {
        List sortedList = new Sorter().sort(listToSort);
        counter.inc();
        return Response.ok(sortedList).build();
    }
}
