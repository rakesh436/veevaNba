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

public class WebElementOperations {

    private enum CONDITION{
        isVISIBLE,
        isPRESENT,
        isCLICKABLE
    }
    protected WebDriver driver = null;

    public WebElementOperations(WebDriver driver){
        this.driver = driver;
    }

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

    protected WebElement elementToBeClickable(By element){
        return waitForElement(element,CONDITION.isCLICKABLE);

    }

    protected WebElement elementToBeVisible(By element){
        return waitForElement(element,CONDITION.isVISIBLE);
    }

    protected List<WebElement> elementsToBeVisible(By element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
    }

    protected WebElement elementToBePresent(By element){
        return waitForElement(element,CONDITION.isPRESENT);
    }

    protected WebDriver switchToTab(WebDriver driver){
        List<String> windowIds = new ArrayList<>(driver.getWindowHandles());
        return driver.switchTo().window(windowIds.get(1));
    }

    protected WebDriver switchToParentTab(WebDriver driver){
        List<String> windowIds = new ArrayList<>(driver.getWindowHandles());
        return driver.switchTo().window(windowIds.get(0));
    }

    protected String getCurrentTitle(){
        return driver.getTitle().trim();
    }



    protected WebElement scrollToElement(By element) {

        JavascriptExecutor je = (JavascriptExecutor) driver;

        try {
            je.executeScript("arguments[0].scrollIntoView(true);",
                    elementToBeVisible(element));
        } catch (StaleElementReferenceException e) {

        }

        return  elementToBeVisible(element);
    }

    public boolean isDisplayed(By element){

        return !driver.findElements(element).isEmpty();
    }

    protected void scrollToBottom(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    protected void selectDropDownByValue(By selectTag,String value){
        WebElement element = elementToBeVisible(selectTag);
        Select select = new Select(element);
        select.selectByValue(value);
    }

}
