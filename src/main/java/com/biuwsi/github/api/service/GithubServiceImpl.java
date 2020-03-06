package com.biuwsi.github.api.service;

import com.biuwsi.github.api.configuration.TemplateConfiguration;
import com.biuwsi.github.api.controller.dto.TemplateType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubServiceImpl implements GithubService {

    private final TemplateConfiguration templateConfiguration;

    public static final String TEMP_FOLDER = "api-github-temp";
    public static final Path TEMP_DIR = Paths.get(System.getProperty("java.io.tmpdir"), TEMP_FOLDER);

    @Override
    public void createTemplate(TemplateType type) {
        ProcessBuilder processBuilder = new ProcessBuilder("", "");

    }

    private Path getTempDirectory(TemplateType type) {
        try {
            Path tempDirPath = Files.exists(TEMP_DIR)
                    ? TEMP_DIR
                    : Files.createTempDirectory(TEMP_FOLDER);

            return tempDirPath;
        } catch (IOException e) {
            log.error("Unable to crate temp directory", e);
            throw new RuntimeException(e);
        }
    }
}
