package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebClickCommands {
    private static final Logger log = LogManager.getLogger(WebClickCommands.class);
    WebDriver driver;

    public WebClickCommands(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to click element : " + element);
        }
    }

    public void clickElement(By byElement) {
        try {
           driver.findElement(byElement).click();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to click element : " + byElement);
        }
    }

    public void submit(WebElement element) {
        try {
            element.submit();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to submit element : " + element);
        }
    }

    public void submit(By byElement) {
        try {
            driver.findElement(byElement).submit();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to submit element : " + byElement);
        }
    }

}