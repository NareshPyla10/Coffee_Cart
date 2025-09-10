package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;



public class WebNavigateCommands {
    private static final Logger log = LogManager.getLogger(WebNavigateCommands.class);
    WebDriver driver;

    public WebNavigateCommands(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToUrl(String url){
       try {
           driver.navigate().to(url);
       }catch (Exception e){
           log.error(e.getMessage());
           throw new RuntimeException("unable to navigate to url : " + url);
       }
    }



    public void navigateBack(){
        try {
            driver.navigate().back();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to navigate back");
        }
    }

    public void navigateForward(){
        try {
            driver.navigate().forward();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to navigate forward");
        }
    }

    public void pageRefresh(){
        try {
            driver.navigate().refresh();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to  refresh page");
        }
    }


}
