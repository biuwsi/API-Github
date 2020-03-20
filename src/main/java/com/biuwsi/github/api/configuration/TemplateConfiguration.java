package com.biuwsi.github.api.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateConfiguration {
    private String type;
    private String tempFolder;
    private String url;
    private String branch;
}
