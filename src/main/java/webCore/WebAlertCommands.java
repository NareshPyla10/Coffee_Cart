package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class WebAlertCommands {
    private static final Logger log = LogManager.getLogger(WebAlertCommands.class);
    WebDriver driver;
    private Alert alert;

    public WebAlertCommands(WebDriver driver) {
        this.driver = driver;
        alert = driver.switchTo().alert();
    }

    public void acceptSimpleAlert() {
        try {
            alert.accept();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to accept the alert ");
        }
    }

    public void dismissSimpleAlert() {
        try {
            alert.dismiss();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to accept the alert ");
        }
    }

    public void sendTextToAlert(String sendKeys) {
        try {
           alert.sendKeys(sendKeys);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to send the keys to alert : " + sendKeys);
        }
    }

    public String getTextFromAlert() {
        try {
            return alert.getText();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("unable to get text from the alert ");
        }
    }
}