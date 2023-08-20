package com.ngs.vna.jmix.core.security.oauth20;

import com.ngs.vna.jmix.core.security.oauth20.config.AuthorizationServerSecurityConfiguration;
import com.ngs.vna.jmix.core.security.oauth20.config.ResourceServerConfiguration;
import com.ngs.vna.jmix.core.security.oauth20.configurer.OAuth2AuthorizationServerConfigurer;
import com.ngs.vna.jmix.core.security.oauth20.configurer.OAuth2ResourceServerConfigurer;
import com.ngs.vna.jmix.core.security.oauth20.impl.UniqueAuthenticationKeyGenerator;
import com.ngs.vna.jmix.core.security.oauth20.store.JmixJdbcTokenStore;
import com.ngs.vna.jmix.core.security.oauth20.web.config.AuthorizationEndpointsConfiguration;
import io.jmix.core.JmixOrder;
import io.jmix.core.impl.StandardSerialization;
import io.jmix.core.security.AuthorizedUrlsProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.sql.DataSource;


@Configuration
public class SecurityOAuth2Configuration {
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(DataSource.class)
    @ConditionalOnBean(DataSource.class)
    @Order(JmixOrder.HIGHEST_PRECEDENCE)
    public static class JdbcTokenStoreConfiguration {
        @Bean(name = "sec_TokenStore")
        @ConditionalOnMissingBean(TokenStore.class)
        public TokenStore tokenStore(DataSource dataSource, StandardSerialization standardSerialization) {
            JmixJdbcTokenStore tokenStore = new JmixJdbcTokenStore(dataSource, standardSerialization);
            tokenStore.setAuthenticationKeyGenerator(new UniqueAuthenticationKeyGenerator());
            return tokenStore;
        }
    }

    @Configuration(proxyBeanMethods = false)
    @Order(JmixOrder.LOWEST_PRECEDENCE)
    public static class InMemoryTokenStoreConfiguration {
        @Bean(name = "sec_TokenStore")
        @ConditionalOnMissingBean(TokenStore.class)
        public TokenStore tokenStore(DataSource dataSource) {
            InMemoryTokenStore tokenStore = new InMemoryTokenStore();
            tokenStore.setAuthenticationKeyGenerator(new UniqueAuthenticationKeyGenerator());
            return tokenStore;
        }
    }

    @Configuration(proxyBeanMethods = false)
    @Import({AuthorizationEndpointsConfiguration.class, AuthorizationServerSecurityConfiguration.class})
    @ConditionalOnBean(AuthorizedUrlsProvider.class)
    @Order(JmixOrder.LOWEST_PRECEDENCE)
    @EnableConfigurationProperties(SecurityOAuth2Properties.class)
    public static class Oauth2AuthorizationServerConfiguration extends OAuth2AuthorizationServerConfigurer {
    }

    @Configuration(proxyBeanMethods = false)
    @Import(ResourceServerConfiguration.class)
    @ConditionalOnBean(AuthorizedUrlsProvider.class)
    @Order(JmixOrder.LOWEST_PRECEDENCE)
    public static class Oauth2ResourceServerConfiguration extends OAuth2ResourceServerConfigurer {
    }
}
