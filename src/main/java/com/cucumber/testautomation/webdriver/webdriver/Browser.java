package com.cucumber.testautomation.webdriver.webdriver;

public enum Browser {

    CHROME("chrome", "webdriver.chrome.driver", "com.bottomline.com.bottomline.testautomation.core.webdriver/chromedriver.exe"),
    FIREFOX("firefox", "webdriver.gecko.driver", "geckodriver.exe");

    private String name;
    private String webDriverPropertyName;
    private String driverFile;

    Browser(String name, String webDriverPropertyName, String driverFile) {
        this.name = name;
        this.webDriverPropertyName = webDriverPropertyName;
        this.driverFile = driverFile;
    }

    public String getName() {
        return name;
    }

    public String getWebDriverPropertyName() {
        return webDriverPropertyName;
    }

    public String getDriverFile() {
        return driverFile;
    }
}
