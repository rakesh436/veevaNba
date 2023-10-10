package com.veeva.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Objects;

public class BaseSetup {

    private WebDriver driver = null;

    public WebDriver getDriver(){
        return this.driver;
    }

    //default browser chrome
    @BeforeClass
    @Parameters("browser")
    public void initDriver(@Optional("chrome") String browser){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.nba.com/warriors/");
    }

    @AfterClass(alwaysRun = true)
    public void kill(){
        if(!Objects.isNull(driver)){
            driver.quit();
        }
    }

}
