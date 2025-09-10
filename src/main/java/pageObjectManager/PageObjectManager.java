package pageObjectManager;

import org.openqa.selenium.WebDriver;
import pages.MenuPage;

public class PageObjectManager {
    WebDriver driver;
    private MenuPage menuPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public MenuPage menuPage(){
        if(menuPage==null){
            menuPage = new MenuPage(driver);
        }
        return menuPage;
    }
}
