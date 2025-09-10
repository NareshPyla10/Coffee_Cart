package webDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

public class WebDriverManager {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(WebDriverManager.class);


    private static WebDriverManager webDriverManager;

    private WebDriverManager(){}

    public static WebDriverManager getWebDriverManager() {
        if (webDriverManager==null){
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriver createDriver(String browser){
        if(driver==null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = createChromeDriver();
                    break;
                case "firefox":
                    driver = createFireFoxDriver();
                    break;
                case "edge":
                    driver = createEdgeDriver();
                    break;
                default:
                    logger.error("Provide a valid browser type");

            }
        }
        return driver;
    }

    private WebDriver createChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        loggingPreferences.enable(LogType.DRIVER, Level.ALL);
        chromeOptions.setCapability("goog:loggingprefs",loggingPreferences);
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("disable-extensions");
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver createEdgeDriver(){
        EdgeOptions edgeOptions = new EdgeOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        loggingPreferences.enable(LogType.DRIVER, Level.ALL);
        edgeOptions.setCapability("goog:loggingprefs",loggingPreferences);
        edgeOptions.addArguments("start-maximized");
        edgeOptions.addArguments("disable-infobars");
        edgeOptions.addArguments("disable-extensions");
        return new EdgeDriver(edgeOptions);
    }

    private WebDriver createFireFoxDriver(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        loggingPreferences.enable(LogType.DRIVER, Level.ALL);
        firefoxOptions.setCapability("moz:loggingprefs",loggingPreferences);
        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.addArguments("disable-infobars");
        firefoxOptions.addArguments("disable-extensions");
        return new FirefoxDriver(firefoxOptions);
    }

    public void quitDriver(){
        if(driver!= null){
            driver.quit();
            logger.info("quitting the driver");
        }
    }
}
