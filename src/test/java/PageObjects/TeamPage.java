package PageObjects;

import com.veeva.base.WebElementOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * The type Team page.
 */
public class TeamPage extends WebElementOperations {
    private By loadMore = By.xpath("//*[text()='Load more']");
    private By loadMoreFlex = By.xpath("//div[@class='xsm:mx-5'][last()]//div[contains(@class,'grow')]");

    /**
     * Instantiates a new Team page.
     *
     * @param driver the driver
     */
    public TeamPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets team title.
     *
     * @return the team title
     */
    public String getTeamTitle() {
        elementToBeVisible(By.id("__next"));
        String str = getCurrentTitle();
        return str;
    }

    /**
     * Is load more present boolean.
     *
     * @return the boolean
     */
    public boolean isLoadMorePresent() {
        return isDisplayed(loadMore);
    }

    /**
     * Click on load more team page.
     *
     * @return the team page
     */
    public TeamPage clickOnLoadMore() {

        if (isLoadMorePresent()) {
            scrollToElement(loadMore).click();
        } else {
            scrollToBottom();
        }

        return this;
    }

    /**
     * Gets load more flex list.
     *
     * @return the load more flex list
     */
    public List<WebElement> getLoadMoreFlexList() {
        scrollToElement(loadMoreFlex);
        return elementsToBeVisible(loadMoreFlex);

    }

    /**
     * Goto home page.
     *
     * @return the home page
     */
    public HomePage gotoHomePage(){
        driver.close();
        return new HomePage(switchToParentTab(driver));
    }
}
