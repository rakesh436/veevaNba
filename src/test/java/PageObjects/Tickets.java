package PageObjects;

import com.veeva.base.WebElementOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The type Tickets.
 */
public class Tickets extends WebElementOperations {


    /**
     * Instantiates a new Tickets.
     *
     * @param driver the driver
     */
    public Tickets(WebDriver driver) {
        super(driver);

    }


    private By firstTicket = By.xpath("(//div[@data-season-type])[1]//*[text()=' Tickets']");

    /**
     * Click on ticket ticket master.
     *
     * @return the ticket master
     */
    public TicketMaster clickOnTicket(){
        scrollToElement(firstTicket);
        elementToBeVisible(firstTicket).click();
        return new TicketMaster(switchToTab(driver));
    }
}
