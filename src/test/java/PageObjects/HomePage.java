package PageObjects;

import com.veeva.base.WebElementOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends WebElementOperations {

    private By teams = By.xpath("//button[@data-testid='button-teams']");
    private String teamName = "//ul[@id='teams']//a[text()='%s']";
    private By dialog = By.xpath("//div[@role='dialog']");
    private By sliderList = By.xpath("//span[contains(@class,'swiper-pagination-bullet')]");//active
    private String menuPath ="//div[contains(@class,'headerMenu')]//*[text()='%s']";
    private String subMenuPath = menuPath + "/parent::a/following-sibling::nav";
    private By ticketMenu = By.xpath(String.format(menuPath,"Tickets"));
    private By subTicketMenu = By.xpath(String.format(subMenuPath,"Tickets"));
    private String ticketSubMenuPath = "(//a[text()='%s'])[1]";
    private By watchVideo = By.xpath("(//*[text()='Watch Video'])[1]");


    public HomePage(WebDriver driver) {
        super(driver);
    }
public HomePage closeDialogBox(){
        elementToBeVisible(dialog);
        elementToBeVisible(By.xpath("//div[text()='x']")).click();
        return this;
}
    public HomePage gotoTeamsDropDown(){
        closeDialogBox();
        moveCrusorToElement(teams);
        return this;
    }

    public TeamPage clickOnTeam(String team){
        By el = By.xpath(String.format(teamName,team));
        elementToBeClickable(el).click();
        return new TeamPage(switchToTab(driver));
    }

    public HomePage gotoTicketsMenu(){
        moveCrusorToElement(ticketMenu);
        return this;
    }

    public Tickets clickOnTicketOptions(String option){
        By singleGameTicket = By.xpath(String.format(ticketSubMenuPath,option));
        gotoTicketsMenu().elementToBeVisible(subTicketMenu);
        elementToBeVisible(singleGameTicket).click();
        return new Tickets(driver);
    }

    public HomePage clickOnWatchVideo(){
        scrollToElement(watchVideo);
        elementToBeVisible(watchVideo).click();
        return this;
    }
}
