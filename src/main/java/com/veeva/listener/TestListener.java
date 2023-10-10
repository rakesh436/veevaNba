package com.veeva.listener;

import com.veeva.base.BaseSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        takeScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        takeScreenshot(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    private void takeScreenshot(ITestResult result) {
        WebDriver driver = ((BaseSetup) result.getInstance()).getDriver();

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String packageName = result.getInstanceName().substring(0, result.getInstanceName().lastIndexOf('.'));
            String className = result.getInstance().getClass().getSimpleName().trim();
            String testName = result.getMethod().getMethodName() + "_";
            String todaysDate = LocalDate.now().toString();
            String todaysTime = LocalTime.now().toString();
            todaysTime = todaysTime.replaceAll(":", "_");
            String fileName =
                        System.getProperty("user.dir")
                            + File.separator
                            + "screenshots"
                            + File.separator
                            + packageName
                            + File.separator
                            + todaysDate
                            + File.separator
                            + className
                            + File.separator
                            + testName
                            + todaysTime
                            + ".jpg";
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
