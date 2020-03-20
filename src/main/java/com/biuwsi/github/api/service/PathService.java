package com.biuwsi.github.api.service;

import java.nio.file.Path;

public interface PathService {
    Path getRepositoryPath(String tempFolder);
}
