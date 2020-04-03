package com.biuwsi.github.api.service;

import java.nio.file.Path;
import java.util.Map;

public interface TemplateService {
    void generateTemplate(Map<String, String> fields, Path repositoryPath);
}
