package com.biuwsi.github.api.service.impl;

import com.biuwsi.github.api.configuration.CookiecutterProperties;
import com.biuwsi.github.api.service.ProcessService;
import com.biuwsi.github.api.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    public static final String EQUATION_SIGN = "=";

    private final CookiecutterProperties cookiecutterProperties;
    private final ProcessService processService;

    @Override
    public void generateTemplate(Map<String, String> fields, Path repositoryPath) {
        List<String> fieldList = fields.entrySet()
                .stream()
                .filter(entry -> cookiecutterProperties.getFields().contains(entry.getKey()))
                .map(entry -> entry.getKey() + EQUATION_SIGN + entry.getValue())
                .collect(Collectors.toList());

        ArrayList<String> command = new ArrayList<>();
        command.addAll(cookiecutterProperties.getCommand());
        command.add(repositoryPath.toString());
        command.addAll(fieldList);

        processService.execute(command, repositoryPath);
    }
}
