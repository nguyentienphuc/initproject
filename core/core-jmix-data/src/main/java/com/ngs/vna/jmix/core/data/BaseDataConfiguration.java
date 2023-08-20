package com.ngs.vna.jmix.core.data;


import io.jmix.core.CoreConfiguration;
import io.jmix.core.annotation.JmixModule;
import io.jmix.data.DataConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@JmixModule(dependsOn = {CoreConfiguration.class, DataConfiguration.class})
@ConfigurationPropertiesScan
public class BaseDataConfiguration {
}
