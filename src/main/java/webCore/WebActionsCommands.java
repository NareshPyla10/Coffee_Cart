package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebActionsCommands {
    private static final Logger log = LogManager.getLogger(WebActionsCommands.class);
    WebDriver driver;
    Actions actions = new Actions(driver);

    public WebActionsCommands(WebDriver driver) {
        this.driver = driver;
    }

    public void moveToElement(WebElement element) {
        try {
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to move to element ");
        }
    }

    public void moveToElementAndClick(WebElement element) {
        try {
            actions.moveToElement(element).click().build().perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to move to element and click");
        }
    }


    public void doubleClick(WebElement element) {
        try {
            actions.doubleClick(element).perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to double click that element");
        }
    }

    public void clickAndHold(WebElement element) {
        try {
            actions.clickAndHold(element).perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to  click  and hold that element");
        }
    }

    public void dragAndDrop(WebElement source, WebElement destination) {
        try {
            actions.dragAndDrop(source,destination).perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to  click  and hold that element");
        }
    }

    public void contextClick() {
        try {
            actions.contextClick().perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to  right click that element");
        }
    }


    public void contextClick(WebElement element) {
        try {
            actions.contextClick(element).perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to  right click that element");
        }
    }

    public void keysDown(WebElement element) {
        try {
            actions.keyDown(Keys.ARROW_DOWN).perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to  click the keys down arrow");
        }
    }

    public void keysUp(WebElement element) {
        try {
            actions.keyUp(Keys.ARROW_UP).perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to  click the keys up arrow");
        }
    }

    public void keysRight(WebElement element) {
        try {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to  click the keys right arrow");
        }
    }


    public void keysLeft(WebElement element) {
        try {
            actions.sendKeys(Keys.ARROW_LEFT).perform();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to  click the keys left arrow");
        }
    }

    public void sendKeys(String str){
        try {
            actions.sendKeys(str);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("unable to  send the keys : " + str);
        }
    }


}