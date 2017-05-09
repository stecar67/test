package com.imonit;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;


public class SortConfiguration extends Configuration {
    @JsonProperty
    private String metricsHost;

    @JsonProperty
    private String metricsPort;

    public String getMetricsHost() {
        return metricsHost;
    }

    public Integer getMetricsPort() {
        return Integer.decode(metricsPort);
    }
}
