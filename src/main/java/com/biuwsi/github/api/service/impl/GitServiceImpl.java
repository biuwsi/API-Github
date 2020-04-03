package com.biuwsi.github.api.service.impl;

import com.biuwsi.github.api.configuration.CommandsProperties;
import com.biuwsi.github.api.service.GitService;
import com.biuwsi.github.api.service.ProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class GitServiceImpl implements GitService {
    private final CommandsProperties commandsProperties;
    private final ProcessService processService;

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

        processService.execute(pullArgs, path);

        ArrayList<String> checkoutArgs = new ArrayList<>(commandsProperties.getCheckout());
        checkoutArgs.add(branch);

        processService.execute(checkoutArgs, path);
    }

    private void gitClone(String url, Path path) {
        ArrayList<String> cloneArgs = new ArrayList<>(commandsProperties.getClone());
        cloneArgs.add(url);
        cloneArgs.add(path.toString());

        processService.execute(cloneArgs, path);
    }
}
