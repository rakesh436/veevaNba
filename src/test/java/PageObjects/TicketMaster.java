package PageObjects;

import com.veeva.base.WebElementOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketMaster extends WebElementOperations {
    public TicketMaster(WebDriver driver) {
        super(driver);
    }

    private By rightPanel = By.id("ismqp-template-left");
    private By filterDropDown = By.id("filter-bar-quantity");
    private By entireFilter = By.xpath("//div[@data-bdd='filterBarDesktop']");
    private String ticketFstOption = "//ul[@data-bdd='quick-picks-list']/li[%d]";
    private By nextButton = By.xpath("//button[@data-bdd='offer-card-buy-button']");
    private By checkOut = By.xpath("//nav[@id='navigation-tm']//h3");
    private By scrollContent = By.id("scrollContent");

    public TicketMaster waitForRightPanel(){
        elementToBeVisible(rightPanel);
        return this;
    }

    public TicketMaster clickOnTicketFilter(){
        elementToBeVisible(filterDropDown).click();
        return this;
    }

    public TicketMaster selectOneTicket(){
        elementToBeVisible(entireFilter);
        selectDropDownByValue(filterDropDown,"1");
        return this;
    }

    public TicketMaster clickOnTicketReSaleFirstOption(){
        By path = By.xpath(String.format(ticketFstOption,1));
        elementToBeVisible(path).click();
        return this;
    }


    public TicketMaster clickOnNextBTN(){
        elementToBeClickable(nextButton).click();
        return this;
    }

    public String getCheckoutHeader(){
       return elementToBeVisible(checkOut).getText().trim();
    }

    public boolean isScrollContentDispalyed(){
       return isDisplayed(scrollContent);
    }
}
