package com.veeva.test;

import PageObjects.HomePage;
import PageObjects.TicketMaster;
import com.veeva.base.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TicketBookingTest extends BaseSetup {

    @Test(description = "Book ticket")
    public void bookTicket() {

        TicketMaster ticketMaster = new HomePage(getDriver())
                .closeDialogBox()
                .gotoTicketsMenu()
                .clickOnTicketOptions("Single Game Tickets")
                .clickOnTicket();

        String checkoutHeader = ticketMaster.selectOneTicket()
                .clickOnTicketReSaleFirstOption()
                .clickOnNextBTN()
                .getCheckoutHeader();

        Assert.assertEquals(checkoutHeader, "Checkout");

        Assert.assertTrue(ticketMaster.isScrollContentDispalyed());

    }

}
