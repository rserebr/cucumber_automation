package com.cucumber.testautomation.webdriver.webdriver;

import com.cucumber.testautomation.webdriver.filesystem.JarResourcesHandler;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractWebDriverFactory {

    private Map<String, Optional<String>> driverFiles = new HashMap<>();
    private Map<String, String> driverPaths = new HashMap<>();

    AbstractWebDriverFactory() {
        driverFiles.put("Windows 7", windowsFile());
        driverFiles.put("Windows 10", windowsFile());
        driverFiles.put("Mac OS X", macFile());
        driverFiles.put("Linux", linuxFile());
        driverPaths.put("Windows 7", "windows/");
        driverPaths.put("Windows 10", "windows/");
        driverPaths.put("Mac OS X", "mac/");
        driverPaths.put("Linux", "linux/");
    }

    void loadDriverFile() {
        String os = System.getProperty("os.name");
        Optional<String> driverFileName = driverFiles.get(os);
        String driverPlatformPath = driverPaths.get(os);
        if(!driverFileName.isPresent())
            throw new UnsupportedOperationException("Driver not available for " + os);
        loadDriverFile(driverPlatformPath+driverFileName.get());
    }

    private void loadDriverFile(String driverFileName) {
        try {
            URI driverFileLocation = JarResourcesHandler.getClassURI(AbstractWebDriverFactory.class);
            URI driverFile = JarResourcesHandler.getResource(driverFileLocation, "webdrivers/"+driverFileName);
            System.setProperty(driverFilePropertyName(), driverFile.getPath());
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("Unable to load Selenium web driver", e);
        }
    }

    abstract String driverFilePropertyName();
    abstract Optional<String> macFile();
    abstract Optional<String> windowsFile();
    abstract Optional<String> linuxFile();
    abstract WebDriver createWebDriver(boolean headless);

    WebDriver loadAndCreateWebDriver(boolean headless) {
        loadDriverFile();
        return createWebDriver(headless);
    }
}
