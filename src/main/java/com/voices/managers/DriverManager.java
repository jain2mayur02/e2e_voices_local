package com.voices.managers;

import com.voices.enums.DriverType;
import com.voices.enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public DriverManager() {
        driverType = ReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = ReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriverForLaunch() {
        if (driver == null) {
            driver = createDriverForLaunch();
        }
        return driver;
    }

    private WebDriver createDriverForLaunch() {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriverForLaunch();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createLocalDriverForLaunch() {
        switch (driverType) {
            case CHROME:
             //   WebDriverManager.chromedriver().clearDriverCache().setup();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().clearDriverCache().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().clearDriverCache().setup();
                driver = new EdgeDriver();
                break;

        }
        if (ReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReaderManager.getInstance().getConfigReader().getImplicitlyWait()));
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    public void closeDriver() {
        driver.quit();
    }


}
