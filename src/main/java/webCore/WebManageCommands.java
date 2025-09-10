package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebManageCommands {
    private static final Logger log = LogManager.getLogger(WebManageCommands.class);
    WebDriver driver;


    public WebManageCommands(WebDriver driver){
        this.driver = driver;
    }

    public void maximizeWindow(){
       try {
           driver.manage().window().maximize();
       }catch (Exception e){
           log.error(e.getMessage());
           throw new RuntimeException("unable to Maximize the Window " );
       }
    }

    public void fullScreenWindow(){
        try {
            driver.manage().window().fullscreen();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to full screen the Window");
        }
    }

    public void getWindowPosition(){
        try {
            driver.manage().window().getPosition();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to get the window position");
        }
    }

    public void setWindowPosition(Point point){
        try {
            driver.manage().window().setPosition(point);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to set the window position");
        }
    }

    public void getWindowSize(){
        try {
            driver.manage().window().getSize();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to get the window size");
        }
    }

    public void minimizeWindow(){
        try {
            driver.manage().window().minimize();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to minimize the window");
        }
    }


    public void pageTimeOut(long seconds){
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to load the page time out");
        }
    }

    public void implicitWait(long seconds){
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to set implicit wait");
        }
    }

    public void addCookie(Cookie cookie){
        try {
            driver.manage().addCookie(cookie);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to add cookie");
        }
    }

    public void getCookies(){
        try {
            driver.manage().getCookies();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to get cookies");
        }
    }

    public void deleteCookie(Cookie cookie){
        try {
            driver.manage().deleteCookie(cookie);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to delete cookie");
        }
    }

    public void deleteAllCookie(){
        try {
            driver.manage().deleteAllCookies();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to delete all cookie");
        }
    }

    public void deleteAllCookie(String name){
        try {
            driver.manage().deleteCookieNamed(name);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Unable to delete "+ name + " cookie");
        }
    }
}
