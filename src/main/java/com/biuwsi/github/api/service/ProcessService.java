package com.biuwsi.github.api.service;

import java.nio.file.Path;
import java.util.List;

public interface ProcessService {
    void execute(List<String> commands, Path path);
}
