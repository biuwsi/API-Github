package com.biuwsi.github.api.service.impl;

import com.biuwsi.github.api.configuration.GithubProperties;
import com.biuwsi.github.api.configuration.TemplateConfiguration;
import com.biuwsi.github.api.controller.dto.CreateTemplateRequest;
import com.biuwsi.github.api.service.GitService;
import com.biuwsi.github.api.service.GithubService;
import com.biuwsi.github.api.service.PathService;
import com.biuwsi.github.api.service.TemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubServiceImpl implements GithubService {

    private final PathService pathService;
    private final GitService gitService;
    private final GithubProperties githubProperties;
    private final TemplateService templateService;

    @Override
    public void createTemplate(CreateTemplateRequest request) {
        TemplateConfiguration templateConfiguration = githubProperties.getTemplate(request.getType());
        Path repositoryPath = pathService.getRepositoryPath(templateConfiguration.getTempFolder());
        gitService.getLatest(repositoryPath, templateConfiguration.getUrl(), templateConfiguration.getBranch());
        templateService.generateTemplate(request.getFields(), repositoryPath);
    }
}
