package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class WebWindowHandleCommands {
    private static final Logger log = LogManager.getLogger(WebWindowHandleCommands.class);
    WebDriver driver;

    public WebWindowHandleCommands(WebDriver driver) {
        this.driver = driver;
    }

    public void getCurrentWindowHandle(WebElement element) {
        try {
            driver.getWindowHandle();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to get the current window handle");
        }
    }


    public void getCurrentWindowHandles(WebElement element,By byElement) {
        try {
            String parentWindow = driver.getWindowHandle();
            Set<String> childs = driver.getWindowHandles();
            Iterator<String> iterator= childs.iterator();
            while (iterator.hasNext()){
                String childWindow = iterator.next();
                if (!childWindow.equals(parentWindow)) {
                    driver.switchTo().window(childWindow);
                    System.out.println("Child Window Title: " + driver.getTitle());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to get the  window handles");
        }
    }

}