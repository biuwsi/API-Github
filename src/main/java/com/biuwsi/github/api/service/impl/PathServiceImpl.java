package com.biuwsi.github.api.service.impl;

import com.biuwsi.github.api.configuration.GithubProperties;
import com.biuwsi.github.api.service.PathService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class PathServiceImpl implements PathService {

    private static Path TEMP_DIR;

    private final GithubProperties githubProperties;

    @Override
    public Path getRepositoryPath(String tempFolder) {
        Path repositoryPath = TEMP_DIR.resolve(tempFolder);
        createIfNotExist(repositoryPath);
        return repositoryPath;
    }

    private void createIfNotExist(Path path) {
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (Exception exception) {
            log.error("Unable to create directory at: {}", path, exception);
        }
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        TEMP_DIR = Paths.get(System.getProperty("java.io.tmpdir"), githubProperties.getTempSubfolder());
        if (!Files.exists(TEMP_DIR)) {
            Files.createDirectories(TEMP_DIR);
        }
    }
}
