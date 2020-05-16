package test;


import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.appsPage;
import pages.educationPage;
import pages.homePage;
import pages.tedPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class tedPageTest extends config {

    public tedPageTest(){
        super();
    }

    homePage homePageObj;
    appsPage appsPageObj;
    educationPage educationPageObj;
    tedPage tedPageObj;
    String baseUrl = "https://play.google.com/store?hl=en";
    ATUTestRecorder recorder;

    @BeforeTest
    public void setup() throws ATUTestRecorderException {
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
        Date date = new Date();
        recorder = new ATUTestRecorder("videos",
                "TestVideo-"+dateFormat.format(date),false);

        chooseBrowser("firefox");
        driver.get(baseUrl);
        recorder.start();
    }

    @Test
    public void chooseTedApp() throws ATUTestRecorderException {
        homePageObj = new homePage(driver);
        appsPageObj = new appsPage(driver);
        educationPageObj = new educationPage(driver);
        tedPageObj = new tedPage(driver);

        homePageObj.openApps();
        appsPageObj.openCategory();
        educationPageObj.search("ted");
        tedPageObj.chooseTed();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        recorder.stop();
    }



}
