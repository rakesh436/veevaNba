package PageObjects;

import com.veeva.base.WebElementOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tickets extends WebElementOperations {


    public Tickets(WebDriver driver) {
        super(driver);

    }


    private By firstTicket = By.xpath("(//div[@data-season-type])[1]//*[text()=' Tickets']");

    public TicketMaster clickOnTicket(){
        scrollToElement(firstTicket);
        elementToBeVisible(firstTicket).click();
        return new TicketMaster(switchToTab(driver));
    }
}
