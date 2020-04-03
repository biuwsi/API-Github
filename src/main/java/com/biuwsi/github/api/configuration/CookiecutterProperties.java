package com.biuwsi.github.api.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties("cookiecutter")
public class CookiecutterProperties {
    private List<String> command;
    private List<String> fields;
}
