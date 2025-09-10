package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebWaitCommands {

    public static Logger logger = LogManager.getLogger(WebWaitCommands.class);

    WebDriver driver;
    WebDriverWait reqWebDriverWait;

    public WebWaitCommands(WebDriver driver) {
        this.driver = driver;
    }

    public void waitFor(int duration){
        reqWebDriverWait = new WebDriverWait(driver, Duration.ofMillis(duration));
    }

    public void waitForAlertToBePresent(int duration){
        logger.info("Waiting for the alert");
        reqWebDriverWait = new WebDriverWait(driver, Duration.ofMillis(duration));
        reqWebDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    public void visibleOfElement(WebElement element){
        reqWebDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
