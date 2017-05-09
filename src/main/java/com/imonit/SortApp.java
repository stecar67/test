package com.imonit;


import com.codahale.metrics.MetricRegistry;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortApp extends Application<SortConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SortApp.class);
    private MetricRegistry metrics;

    public static void main(String[] args) throws Exception {
        LOGGER.debug("starting up...");
        new SortApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<SortConfiguration> bootstrap) {
        super.initialize(bootstrap);
        metrics = new MetricRegistry();
    }

    @Override
    public void run(SortConfiguration conf, Environment env) throws Exception {
        env.jersey().register(new SortResource(metrics, conf.getMetricsHost(), conf.getMetricsPort()));
    }
}
