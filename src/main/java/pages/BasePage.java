package pages;

import org.openqa.selenium.WebDriver;
import webCore.*;

public abstract class BasePage {

    public WebDriver driver;


    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    private  WebActionsCommands webActionsCommands;
    private WebAlertCommands webAlertCommands;
    private WebClickCommands webClickCommands;
    private WebLaunchCommands webLaunchCommands;
    private WebManageCommands webManageCommands;
    private WebNavigateCommands webNavigateCommands;
    private WebSelectCommands webSelectCommands;
    private WebTextCommands webTextCommands;
    private WebVerifyCommands webVerifyCommands;
    private WebWaitCommands webWaitCommands;



    public WebActionsCommands getWebActionsCommands(){
        if(webActionsCommands==null){
            webActionsCommands =  new WebActionsCommands(driver);
        }
        return webActionsCommands;
    }

    public WebAlertCommands getWebAlertCommands(){
        if(webAlertCommands==null){
            webAlertCommands = new WebAlertCommands(driver);
        }
        return webAlertCommands;
    }

    public WebClickCommands getWebClickCommands(){
        if(webClickCommands==null){
            webClickCommands = new WebClickCommands(driver);
        }
        return webClickCommands;
    }

    public WebLaunchCommands getWebLaunchCommands(){
        if(webLaunchCommands ==null){
            webLaunchCommands = new WebLaunchCommands(driver);
        }
        return webLaunchCommands;
    }

    public WebManageCommands getWebManageCommands(){
        if(webManageCommands== null){
            webManageCommands = new WebManageCommands(driver);
        }
        return webManageCommands;
    }

    public WebNavigateCommands getWebNavigateCommands(){
        if(webNavigateCommands==null){
            webNavigateCommands = new WebNavigateCommands(driver);
        }
        return webNavigateCommands;
    }

    public WebSelectCommands getWebSelectCommands(){
        if(webSelectCommands==null){
            webSelectCommands = new WebSelectCommands(driver);
        }
        return webSelectCommands;
    }

    public WebTextCommands getWebTextCommands(){
        if(webTextCommands == null){
            webTextCommands = new WebTextCommands(driver);
        }
        return webTextCommands;
    }

    public WebVerifyCommands getWebVerifyCommands(){
        if(webVerifyCommands==null){
            webVerifyCommands = new WebVerifyCommands(driver);
        }
        return webVerifyCommands;
    }

    public WebWaitCommands getWebWaitCommands(){
        if(webWaitCommands==null){
            webWaitCommands = new WebWaitCommands(driver);
        }
        return webWaitCommands;
    }

    //wait for the page load
    public abstract boolean waitForPageLoad();
}
