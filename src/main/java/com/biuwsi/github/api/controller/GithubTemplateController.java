package com.biuwsi.github.api.controller;

import com.biuwsi.github.api.controller.dto.CreateTemplateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GithubTemplateController {

    @PostMapping
    public void createTemplate(@RequestBody CreateTemplateRequest createTemplateRequest) {

    }
}
