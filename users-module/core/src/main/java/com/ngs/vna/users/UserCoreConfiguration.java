package com.ngs.vna.users;


import com.ngs.vna.jmix.core.data.BaseDataConfiguration;
import io.jmix.core.annotation.JmixModule;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@JmixModule(dependsOn = {BaseDataConfiguration.class})
@ConfigurationPropertiesScan
@Configuration
@ComponentScan
public class UserCoreConfiguration {

}
