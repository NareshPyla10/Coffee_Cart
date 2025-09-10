package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebSelectCommands {
    private static final Logger log = LogManager.getLogger(WebSelectCommands.class);
    WebDriver driver;
    Select select;

    public WebSelectCommands(WebDriver driver) {
        this.driver = driver;
    }

    public void selectByValue(WebElement element,String value) {
        try {
            select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to select  element : " + value);
        }
    }

    public void selectByIndex(WebElement element,int index) {
        try {
            select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to select  element : " + index);
        }
    }

    public void selectByVisibleText(WebElement element,String text) {
        try {
            select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to select  element : " + text);
        }
    }


    public void deselectByValue(WebElement element,String value) {
        try {
            select = new Select(element);
            select.deselectByValue(value);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to deselect  element : " + value);
        }
    }

    public void deselectByIndex(WebElement element,int index) {
        try {
            select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to deselect  element : " + index);
        }
    }

    public void deselectByVisibleText(WebElement element,String text) {
        try {
            select = new Select(element);
            select.deselectByVisibleText(text);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to deselect  element : " + text);
        }
    }


    public void deselectAll(WebElement element) {
        try {
            select = new Select(element);
            select.deselectAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to deselect  all elements " );
        }
    }


    public void isMultiple(WebElement element) {
        try {
            select = new Select(element);
            select.isMultiple();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to deselect  all elements " );
        }
    }





}