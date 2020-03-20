package com.biuwsi.github.api.service;

import com.biuwsi.github.api.controller.dto.CreateTemplateRequest;

public interface GithubService {
    void createTemplate(CreateTemplateRequest createTemplateRequest);
}
