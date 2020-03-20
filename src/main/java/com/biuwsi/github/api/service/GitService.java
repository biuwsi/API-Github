package com.biuwsi.github.api.service;

import java.nio.file.Path;

public interface GitService {
    void getLatest(Path path, String url, String branch);
}
