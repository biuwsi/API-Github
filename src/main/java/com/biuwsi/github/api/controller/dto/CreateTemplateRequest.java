package com.biuwsi.github.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTemplateRequest {
    private TemplateType type;
    private String projectName;
    private String appName;
    private String mainClassName;
    private String basePackage;
}
