package com.biuwsi.github.api.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties("github.commands")
public class CommandsProperties {
    private List<String> pull;
    private List<String> clone;
    private List<String> checkout;
}
