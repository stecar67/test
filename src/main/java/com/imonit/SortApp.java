package com.imonit;


import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortApp extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SortApp.class);

    public static void main(String[] args) throws Exception {
        LOGGER.debug("starting up...");
        new SortApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new SortResource());
    }
}
