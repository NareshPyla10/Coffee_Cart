package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuStepDef {
    TestContest testContest;

    public MenuStepDef(TestContest testContest){
        this.testContest = testContest;
    }

    @Given("Launching the website")
    public void launchingTheWebsite(){
        testContest.getPageObjectManager().menuPage().launchingWebsite(testContest.getFileReaderManager().getPropertyFileReader().getProperty("url"));
    }

    @When("click the menu link")
    public void clickTheMenuLink() {
        testContest.getPageObjectManager().menuPage().navigatingToTheMenuPage();
        assertThat(testContest.getPageObjectManager().menuPage().waitForPageLoad()).isTrue();
    }

    @And("Adding item to the cart")
    public void addingItemToTheCart() {
        testContest.getPageObjectManager().menuPage().addingItems();
    }

    @And("navigating to the cart link")
    public void navigatingToTheCartLink() {
        testContest.getPageObjectManager().menuPage().navigateToCartLink();
    }


    @Then("the cart should contain one item")
    public void theCartShouldContainOneItem() {
        testContest.getPageObjectManager().menuPage().linksSize();
    }

    @And("Adding multiple items to the cart")
    public void addingMultipleItemsToTheCart() {
        testContest.getPageObjectManager().menuPage().addingMultipleItem();
    }


    @Then("adding same item second time")
    public void addingSameItemSecondTime() {
        testContest.getPageObjectManager().menuPage().pressingPlusButton();
    }

    @Then("adding items each one is two items")
    public void addingItemsEachOneIsTwoItems() {
        testContest.getPageObjectManager().menuPage().requiredValuesFromTable("Total","Americano");
    }

    @Then("the cart should contain multiple items")
    public void theCartShouldContainMultipleItems() {
        testContest.getPageObjectManager().menuPage().linksSize();
    }

    @And("adding same items to the cart second time")
    public void addingSameItemsToTheCartSecondTime() {
        testContest.getPageObjectManager().menuPage().pressingMultipleClickButton();
    }

    @Then("pay the money for the items")
    public void payTheMoneyForTheItems() {
        testContest.getPageObjectManager().menuPage().payingTheMoney("gilly","abcd@123gmail.com");
        System.out.println("The payment is success");
        testContest.getPageObjectManager().menuPage().getWebLaunchCommands().quitBrowser();
    }
}
