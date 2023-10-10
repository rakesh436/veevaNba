package PageObjects;

import com.veeva.base.WebElementOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TeamPage extends WebElementOperations {
    private By loadMore = By.xpath("//*[text()='Load more']");
    private By loadMoreFlex = By.xpath("//div[@class='xsm:mx-5'][last()]//div[contains(@class,'grow')]");

    public TeamPage(WebDriver driver) {
        super(driver);
    }

    public String getTeamTitle() {
        elementToBeVisible(By.id("__next"));
        String str = getCurrentTitle();
        System.out.println(str + "-----------");
        return str;
    }

    public boolean isLoadMorePresent() {
        return isDisplayed(loadMore);
    }

    public TeamPage clickOnLoadMore() {

        if (isLoadMorePresent()) {
            scrollToElement(loadMore).click();
        } else {
            scrollToBottom();
        }

        return this;
    }

    public List<WebElement> getLoadMoreFlexList() {
        scrollToElement(loadMoreFlex);
        return elementsToBeVisible(loadMoreFlex);

    }

    public HomePage gotoHomePage(){
        driver.close();
        return new HomePage(switchToParentTab(driver));
    }
}
