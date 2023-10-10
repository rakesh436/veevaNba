package com.veeva.test;

import PageObjects.HomePage;
import PageObjects.TeamPage;
import com.veeva.base.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeTest extends BaseSetup {

    @Test(description = "Click on team name")
    public void selectTeam() {

        HomePage homePage = new HomePage(getDriver());

        TeamPage teamPage = homePage.gotoTeamsDropDown()
                .clickOnTeam("Golden State");

        String title = teamPage.getTeamTitle();
        Assert.assertTrue(title.contains("Golden State Warriors"));

    }


}
