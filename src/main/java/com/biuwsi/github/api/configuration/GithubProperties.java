package com.biuwsi.github.api.configuration;

import com.biuwsi.github.api.controller.dto.TemplateType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@Configuration
@ConfigurationProperties("github")
public class GithubProperties {
    private String tempSubfolder;
    private List<TemplateConfiguration> templates;

    @Getter(value = AccessLevel.NONE)
    private Map<TemplateType, TemplateConfiguration> configurations;

    public TemplateConfiguration getTemplate(TemplateType templateType) {
        return configurations.get(templateType);
    }

    @PostConstruct
    public void postConstruct() {
        configurations = templates.stream()
                .collect(Collectors.toMap((a) -> TemplateType.valueOf(a.getType()), Function.identity()));
    }
}
