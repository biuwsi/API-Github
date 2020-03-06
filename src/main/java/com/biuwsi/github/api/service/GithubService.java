package com.biuwsi.github.api.service;

import com.biuwsi.github.api.controller.dto.TemplateType;

public interface GithubService {
    void createTemplate(TemplateType type);
}
