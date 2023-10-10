package com.veeva.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Web element operations.
 */
/*
A common class to handle all webElement operation
 */
public class WebElementOperations {

    private enum CONDITION{
        /**
         * Is visible condition.
         */
        isVISIBLE,
        /**
         * Is present condition.
         */
        isPRESENT,
        /**
         * Is clickable condition.
         */
        isCLICKABLE
    }

    /**
     * The Driver.
     */
    protected WebDriver driver = null;

    /**
     * Instantiates a new Web element operations.
     *
     * @param driver the driver
     */
    public WebElementOperations(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Move crusor to element.
     *
     * @param element the element
     */
    protected void moveCrusorToElement(By element){
        Actions actions = new Actions(driver);
        actions.moveToElement(waitForElement(element,CONDITION.isVISIBLE)).build().perform();
    }

    private WebElement waitForElement(By element,CONDITION condition){

        WebDriverWait wait =   new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((
                ExpectedCondition<Boolean>)
                wd ->
                        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        switch (condition){
            case isPRESENT -> {
                return wait.until(ExpectedConditions.presenceOfElementLocated(element));

            }
            case isCLICKABLE -> {
                return wait.until(ExpectedConditions.elementToBeClickable(element));

            }
            default -> {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            }
        }

    }

    /**
     * Element to be clickable web element.
     *
     * @param element the element
     * @return the web element
     */
    protected WebElement elementToBeClickable(By element){
        return waitForElement(element,CONDITION.isCLICKABLE);

    }

    /**
     * Element to be visible web element.
     *
     * @param element the element
     * @return the web element
     */
    protected WebElement elementToBeVisible(By element){
        return waitForElement(element,CONDITION.isVISIBLE);
    }

    /**
     * Elements to be visible list.
     *
     * @param element the element
     * @return the list
     */
    protected List<WebElement> elementsToBeVisible(By element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
    }

    /**
     * Element to be present web element.
     *
     * @param element the element
     * @return the web element
     */
    protected WebElement elementToBePresent(By element){
        return waitForElement(element,CONDITION.isPRESENT);
    }

    /**
     * Switch to tab web driver.
     *
     * @param driver the driver
     * @return the web driver
     */
    protected WebDriver switchToTab(WebDriver driver){
        List<String> windowIds = new ArrayList<>(driver.getWindowHandles());
        return driver.switchTo().window(windowIds.get(1));
    }

    /**
     * Switch to parent tab web driver.
     *
     * @param driver the driver
     * @return the web driver
     */
    protected WebDriver switchToParentTab(WebDriver driver){
        List<String> windowIds = new ArrayList<>(driver.getWindowHandles());
        return driver.switchTo().window(windowIds.get(0));
    }

    /**
     * Get current title string.
     *
     * @return the string
     */
    protected String getCurrentTitle(){
        return driver.getTitle().trim();
    }


    /**
     * Scroll to element web element.
     *
     * @param element the element
     * @return the web element
     */
    protected WebElement scrollToElement(By element) {

        JavascriptExecutor je = (JavascriptExecutor) driver;

        try {
            je.executeScript("arguments[0].scrollIntoView(true);",
                    elementToBeVisible(element));
        } catch (StaleElementReferenceException e) {

        }

        return  elementToBeVisible(element);
    }

    /**
     * Is displayed boolean.
     *
     * @param element the element
     * @return the boolean
     */
    public boolean isDisplayed(By element){

        return !driver.findElements(element).isEmpty();
    }

    /**
     * Scroll to bottom.
     */
    protected void scrollToBottom(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    /**
     * Select drop down by value.
     *
     * @param selectTag the select tag
     * @param value     the value
     */
    protected void selectDropDownByValue(By selectTag,String value){
        WebElement element = elementToBeVisible(selectTag);
        Select select = new Select(element);
        select.selectByValue(value);
    }

}
