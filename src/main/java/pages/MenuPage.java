package pages;

import com.aventstack.extentreports.util.Assert;
import io.cucumber.java.sl.In;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





import java.time.Duration;
import java.util.List;

public class MenuPage extends BasePage{

    private WebDriverWait menuPageWait;


    private static final Logger logger = LogManager.getLogger(MenuPage.class);

    public MenuPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='menu']")
    WebElement menuLink;

    @FindBy(xpath = "//div[@aria-label='Espresso']")
    WebElement item1;

    @FindBy(xpath = "//div[@aria-label='Mocha']")
    WebElement item2;

    @FindBy(xpath = "//div[@aria-label='Americano']")
    WebElement item3;

    @FindBy(xpath = "//a[contains(@aria-label, 'Cart')]")
    WebElement cartLink;

    @FindBy(xpath = "//ul[@data-v-8965af83]/li[@class='list-item']")
    List<WebElement> links;

    @FindBy(xpath = "//li[@class='list-header']/div")
    List<WebElement> listItemHeaders;

    @FindBy(xpath = "(//button[contains(@aria-label,'Add')])[2]")
    WebElement plusButton;

    @FindBy(xpath = "//div[contains(text(),'$')]")
    WebElement costButton;

    @FindBy(xpath = "(//li[@class='list-header']/following-sibling::li[2]//button[text()='+'])")
    WebElement multiplePlusButton;

    @FindBy(xpath = "//button[@data-test='checkout']")
    WebElement totalButton;

    @FindBy(id = "name")
    WebElement nameInputButton;

    @FindBy(id = "email")
    WebElement emailInputButton;

    @FindBy(id = "promotion")
    WebElement checkbox;

    @FindBy(id = "submit-payment")
    WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'snackbar ')]")
    WebElement snackBar;

    @FindBy(xpath = "//a[contains(@class,'router-link-active')]")
    private WebElement selectedMenu;

    @FindBy(xpath = "//h4[@data-v-a9662a08]")
    private List<WebElement> allItems;

    @Override
    public boolean waitForPageLoad() {
        try{
            menuPageWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return menuPageWait.until(driver -> menuLink.isDisplayed());
        }catch (Exception e){
            System.out.println("Failed in waiting for menu page to load : " + e.getMessage());
            return false;
        }

    }


    public boolean verifySelectedPageHeader(String reqPage){
       return getWebTextCommands().getText(selectedMenu).contains(reqPage);
    }

    public void launchingWebsite(String url){
        getWebLaunchCommands().openingBrowser(url);
    }

    public void navigatingToTheMenuPage(){
        getWebClickCommands().clickElement(menuLink);
    }

    public void addingItems(){
        getWebClickCommands().clickElement(item1);
    }

    public void navigateToCartLink(){
        getWebClickCommands().clickElement(cartLink);
    }

    public void linksSize() {
        int itemName = 1;
        for (int i=0;i<listItemHeaders.size();i++){
            String elementName = listItemHeaders.get(i).getText();
            if (elementName.equalsIgnoreCase("Item")){
                itemName = i;
            }
        }
        List<WebElement> itemNames = driver.findElements(By.xpath("//li[@class='list-item']/div[" + (itemName+1) + "]"));

        for (WebElement items:itemNames){
            String names = items.getText();
            System.out.println(names);
        }
    }

    public void addingMultipleItem(){

        getWebClickCommands().clickElement(item1);
        getWebClickCommands().clickElement(item2);
        getWebClickCommands().clickElement(item3);
    }

    public void pressingPlusButton(){
        getWebWaitCommands().waitFor(3000);
        getWebWaitCommands().visibleOfElement(costButton);
        System.out.println(costButton.getText());
        getWebClickCommands().clickElement(plusButton);
        System.out.println(costButton.getText());
    }

    public void requiredValuesFromTable(String value,String headerName){
        List<WebElement> headerNames = driver.findElements(By.xpath("//li[@class='list-header']//div"));
        String requiredColumn = "";
        for (int i=1;i<=headerNames.size();i++){
            WebElement namesOfHeaders = driver.findElement(By.xpath("//li[@class='list-header']//div["+i+"]"));
            String name = namesOfHeaders.getText();
            if (name.equalsIgnoreCase(value)){
                requiredColumn += i;
            }
        }

        String reqValue = "";
        List<WebElement> rowItems = driver.findElements(By.xpath("//li[@class='list-header']/following-sibling::li"));
        for (int i=1;i<=rowItems.size();i++){
            for (int j=1;j<=headerNames.size();j++){
                WebElement element = driver.findElement(By.xpath("//li[@class='list-header']/following-sibling::li["+i+"]//div["+j+"]"));
                String elementName = element.getText();
                if (elementName.equalsIgnoreCase(headerName)){
                    reqValue += driver.findElement(By.xpath("//li[@class='list-header']/following-sibling::li["+i+"]//div["+requiredColumn+"]")).getText();
                }
            }
        }
        System.out.println("The item passed is: " + headerName + " And that cost is: " + reqValue);
    }

    public void pressingMultipleClickButton(){
        List<WebElement> rowItems = driver.findElements(By.xpath("//li[@class='list-header']/following-sibling::li"));
        for (int i=1;i<=rowItems.size();i++){
            WebElement plusButton = driver.findElement(By.xpath("(//li[@class='list-header']/following-sibling::li["+i+"]//button[text()='+'])"));
            getWebClickCommands().clickElement(plusButton);
        }
    }

    public void payingTheMoney(String name, String email){
        getWebClickCommands().clickElement(totalButton);
        getWebTextCommands().clearAndEnterText(nameInputButton,name);
        getWebTextCommands().clearAndEnterText(emailInputButton,email);
        getWebClickCommands().clickElement(checkbox);
        getWebClickCommands().clickElement(submitButton);
        getWebTextCommands().getText(snackBar);
    }


    public void gettingAllItemNames(){
        System.out.println("Found items: " + allItems.size());
        for (WebElement names: allItems){
            String fullText = names.getAttribute("textContent");
            String name = fullText.split("\\$")[0].trim();
            System.out.println(name);
        }
    }

    public void validatingAllItemAreChangedIntoChinese(){
        for (WebElement list: allItems){
            String fullText = list.getAttribute("textContent");
            String name = fullText.split("\\$")[0].trim();
            boolean chinese = name.codePoints().anyMatch(ch -> Character.UnicodeScript.of(ch)==Character.UnicodeScript.HAN);
        }
    }

}
