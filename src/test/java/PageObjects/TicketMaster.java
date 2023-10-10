package PageObjects;

import com.veeva.base.WebElementOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The type Ticket master.
 */
public class TicketMaster extends WebElementOperations {
    /**
     * Instantiates a new Ticket master.
     *
     * @param driver the driver
     */
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

    /**
     * Wait for right panel ticket master.
     *
     * @return the ticket master
     */
    public TicketMaster waitForRightPanel(){
        elementToBeVisible(rightPanel);
        return this;
    }

    /**
     * Click on ticket filter ticket master.
     *
     * @return the ticket master
     */
    public TicketMaster clickOnTicketFilter(){
        elementToBeVisible(filterDropDown).click();
        return this;
    }

    /**
     * Select one ticket ticket master.
     *
     * @return the ticket master
     */
    public TicketMaster selectOneTicket(){
        elementToBeVisible(entireFilter);
        selectDropDownByValue(filterDropDown,"1");
        return this;
    }

    /**
     * Click on ticket re sale first option ticket master.
     *
     * @return the ticket master
     */
    public TicketMaster clickOnTicketReSaleFirstOption(){
        By path = By.xpath(String.format(ticketFstOption,1));
        elementToBeVisible(path).click();
        return this;
    }


    /**
     * Click on next btn ticket master.
     *
     * @return the ticket master
     */
    public TicketMaster clickOnNextBTN(){
        elementToBeClickable(nextButton).click();
        return this;
    }

    /**
     * Get checkout header string.
     *
     * @return the string
     */
    public String getCheckoutHeader(){
       return elementToBeVisible(checkOut).getText().trim();
    }

    /**
     * Is scroll content dispalyed boolean.
     *
     * @return the boolean
     */
    public boolean isScrollContentDispalyed(){
       return isDisplayed(scrollContent);
    }
}
