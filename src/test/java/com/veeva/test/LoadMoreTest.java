package com.veeva.test;

import PageObjects.HomePage;
import PageObjects.TeamPage;
import com.veeva.base.BaseSetup;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;

public class LoadMoreTest extends BaseSetup {
    @Test(description = "Click on load more button")
    public void clickOnLoadMore() {

        TeamPage teamPage = new HomePage(getDriver())
                .gotoTeamsDropDown()
                .clickOnTeam("Golden State");

        List<WebElement> flexList = teamPage.getLoadMoreFlexList();
        Reporter.log("Initial flex list : " + flexList.size());
        teamPage.clickOnLoadMore();
        List<WebElement> flexList1 = teamPage.getLoadMoreFlexList();

        Assert.assertEquals(flexList1.size(), flexList.size() + 8);


    }
}
