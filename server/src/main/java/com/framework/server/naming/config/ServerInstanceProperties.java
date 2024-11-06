package com.framework.server.naming.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "server.instance")
@Data
public class ServerInstanceProperties {
    private long timeout;
}
