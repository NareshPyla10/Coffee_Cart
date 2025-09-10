package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTextCommands {
    private static final Logger log = LogManager.getLogger(WebTextCommands.class);
    WebDriver driver;

    public WebTextCommands(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(WebElement element,String text) {
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to send the text ");
        }
    }

    public void enterText(By byElement, String text) {
        try {
            driver.findElement(byElement).sendKeys(text);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to send the text ");
        }
    }

    public String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to get the text ");
        }
    }

    public String getText(By byElement) {
        try {
            return driver.findElement(byElement).getText();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to get the text ");
        }
    }

    public void clearText(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to clear the text ");
        }
    }

    public void clearText(By byElement) {
        try {
            driver.findElement(byElement).clear();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to clear the text ");
        }
    }

    public void clearAndEnterText(By byElement,String text) {
        try {
            driver.findElement(byElement).clear();
            driver.findElement(byElement).sendKeys(text);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to clear and enter the text ");
        }
    }

    public void clearAndEnterText(WebElement element,String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to clear and enter the text ");
        }
    }

    public String getElementProperty(WebElement element,String property) {
        try {
            return element.getDomProperty(property);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to get the dom property");
        }
    }

    public String getElementProperty(By byElement,String property) {
        try {
            return driver.findElement(byElement).getDomProperty(property);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to get the dom property");
        }
    }




}