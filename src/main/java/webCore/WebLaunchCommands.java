package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebLaunchCommands {
    private static final Logger log = LogManager.getLogger(WebLaunchCommands.class);
    WebDriver driver;

    public WebLaunchCommands(WebDriver driver){
        this.driver = driver;
    }

    public void openingBrowser(String url){
       try {
           driver.get(url);
       }catch (Exception e){
           log.error(e.getMessage());
           throw new RuntimeException("unable to launch url : " + url);
       }
    }

    public void closingBrowser(){
        try {
            driver.quit();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to close the browser");
        }
    }

    public void quitBrowser(){
        try {
            driver.quit();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to quit the browser");
        }
    }

    public String getTitle(){
        try {
            return  driver.getTitle();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to get the title ");
        }
    }

    public String currentWindowUrl(){
        try {
            return driver.getCurrentUrl();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to get the current window url");
        }
    }

    public String getPageSource(){
        try {
            return driver.getPageSource();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to get the page source");
        }
    }

}
