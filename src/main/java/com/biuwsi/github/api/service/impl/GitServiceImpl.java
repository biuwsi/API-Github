package com.biuwsi.github.api.service.impl;

import com.biuwsi.github.api.configuration.CommandsProperties;
import com.biuwsi.github.api.service.GitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GitServiceImpl implements GitService {

    private static final int SUCCESS_TERMINATION_CODE = 0;

    private final CommandsProperties commandsProperties;

    @Override
    public void getLatest(Path path, String url, String branch) {
        if (Files.exists(path.resolve(".git"))) {
            gitPull(branch, path);
        } else {
            gitClone(url, path);
        }
    }

    public void gitPull(String branch, Path path) {
        ArrayList<String> pullArgs = new ArrayList<>(commandsProperties.getPull());
        pullArgs.add(branch);

        execute(pullArgs, path);

        ArrayList<String> checkoutArgs = new ArrayList<>(commandsProperties.getCheckout());
        checkoutArgs.add(branch);

        execute(checkoutArgs, path);
    }

    private void gitClone(String url, Path path) {
        ArrayList<String> cloneArgs = new ArrayList<>(commandsProperties.getClone());
        cloneArgs.add(url);
        cloneArgs.add(path.toString());

        execute(cloneArgs, path);
    }

    private void execute(List<String> commands, Path path) {
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
