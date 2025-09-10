package webCore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebVerifyCommands {

    public static Logger logger = LogManager.getLogger(WebVerifyCommands.class);

    WebDriver driver;

    public WebVerifyCommands(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method is to verify the element is displayed or not
     *
     * @param element method parameter or argument is an element
     * @return true or false based on the element visibility
     */
    public boolean verifyElementIsDisplayed(WebElement element) {
        try {
            logger.info("Verifying the element: {}", element);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            logger.error("Error in finding the element: {}", element);
            logger.error(e.getMessage());
            return false;
        }
    }


    /**
     * This method is to verify the element is displayed or not
     *
     * @param byElement method parameter or argument is an element
     * @return true or false based on the element visibility
     */
    public boolean verifyElementIsDisplayed(By byElement) {
        try {
            logger.info("Verifying the element: {}", byElement);
            return driver.findElement(byElement).isDisplayed();
        } catch (NoSuchElementException e) {
            logger.error("Error in finding the element: {}", byElement);
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * This method is to verify the element is enabled or not
     *
     * @param element method parameter or argument is an element
     * @return true or false based on the element enabled or not
     */
    public boolean verifyElementIsEnabled(WebElement element) {
        try {
            logger.info("Verifying the element: {}", element);
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            logger.error("Error in finding the element: {}", element);
            logger.error(e.getMessage());
            return false;
        }
    }


    /**
     * This method is to verify the element is enabled or not
     *
     * @param byElement method parameter or argument is an element
     * @return true or false based on the element enabled or not
     */
    public boolean verifyElementIsEnabled(By byElement) {
        try {
            logger.info("Verifying the element: {}", byElement);
            return driver.findElement(byElement).isEnabled();
        } catch (NoSuchElementException e) {
            logger.error("Error in finding the element: {}", byElement);
            logger.error(e.getMessage());
            return false;
        }
    }



    /**
     * This method is to verify the element is selected or not
     *
     * @param element method parameter or argument is an element
     * @return true or false based on the element selected or not
     */
    public boolean verifyElementIsSelected(WebElement element) {
        try {
            logger.info("Verifying the element: {}", element);
            return element.isSelected();
        } catch (NoSuchElementException e) {
            logger.error("Error in finding the element  is selected : {}", element);
            logger.error(e.getMessage());
            return false;
        }
    }


    /**
     * This method is to verify the element is selected or not
     *
     * @param byElement method parameter or argument is an element
     * @return true or false based on the element selected or not
     */
    public boolean verifyElementIsSelected(By byElement) {
        try {
            logger.info("Verifying the element: {}", byElement);
            return driver.findElement(byElement).isSelected();

        } catch (NoSuchElementException e) {
            logger.error("Error in finding the element is selected: {}", byElement);
            logger.error(e.getMessage());
            return false;
        }
    }



    public boolean verifyElementIsNotPresent(By byElement) {
        try {
            logger.info("Verifying the element is not present: {}", byElement);
            return driver.findElements(byElement).isEmpty();

        } catch (NoSuchElementException e) {
            logger.error("Error in finding the element is selected: {}", byElement);
            logger.error(e.getMessage());
            return false;
        }
    }







    public static void main(String[] args) {
        logger.info("Testing");
    }

}
