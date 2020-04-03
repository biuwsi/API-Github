package com.biuwsi.github.api.service.impl;

import com.biuwsi.github.api.service.ProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private static final int SUCCESS_TERMINATION_CODE = 0;

    @Override
    public void execute(List<String> commands, Path path) {
        try {
            Process process = startProcess(commands, path);
            int processTerminationCode = process.waitFor();

            if (SUCCESS_TERMINATION_CODE != processTerminationCode) {
                log.error("Process terminated unsuccessfully: {}", processTerminationCode);
                throw new RuntimeException();
            }
        } catch (InterruptedException e) {
            log.error("Process was interrupted", e);
        }
    }

    private Process startProcess(List<String> commands, Path path) {
        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        processBuilder.directory(path.toFile());
        try {
            return processBuilder.start();
        } catch (IOException e) {
            log.error("Unable to start process", e);
            throw new RuntimeException();
        }
    }
}
