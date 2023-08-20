package com.ngs.vna.users.sercurity;


import com.ngs.vna.users.UserCoreConfiguration;
import io.jmix.core.annotation.JmixModule;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@JmixModule(dependsOn = UserCoreConfiguration.class)
@ConfigurationPropertiesScan
@ComponentScan
public class UserSecurityConfiguration {
}
