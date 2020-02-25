package com.cucumber.testautomation.webdriver.filesystem;

import java.io.File;
import java.util.Objects;
import java.util.Optional;

public class RecursiveFileFinder {

    public Optional<File> findFile(String rootDirectory, String fileName) {
        File rootDir = new File(rootDirectory);
        File[] contents = rootDir.listFiles();
        for (File content : Objects.requireNonNull(contents)) {
            if (content.isFile()) {
                if (content.getName().contains(fileName)) {
                    return Optional.of(content);
                }
            }
            if (content.isDirectory()) {
                Optional<File> configFile = findFile(content.getAbsolutePath(), fileName);
                if (configFile.isPresent())
                    return configFile;
            }
        }
        return Optional.empty();
    }
}
