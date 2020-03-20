package com.biuwsi.github.api.service.impl;

import com.biuwsi.github.api.configuration.CookiecutterProperties;
import com.biuwsi.github.api.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private final CookiecutterProperties cookiecutterProperties;

    public void generateTemplate(Path path, String projectName, String appName, String mainClass, String basePackage) {

    }
}
