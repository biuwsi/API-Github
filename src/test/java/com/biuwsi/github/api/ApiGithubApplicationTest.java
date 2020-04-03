package com.biuwsi.github.api;

import com.biuwsi.github.api.controller.dto.CreateTemplateRequest;
import com.biuwsi.github.api.controller.dto.TemplateType;
import com.biuwsi.github.api.service.GithubService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiGithubApplicationTest {

    @Autowired
    private GithubService githubService;

    @Test
    void contextLoads() {
        githubService.createTemplate(CreateTemplateRequest.builder()
                .type(TemplateType.MICROSERVICE)
                .field("project_name", "api-test")
                .field("app_name", "api-test")
                .field("main_class_name", "ApiTest")
                .field("base_package", "test.api")
                .build());
    }

}
