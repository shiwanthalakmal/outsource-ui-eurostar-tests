package com.outsource.qa.stepDefinitions;

import com.outsource.qa.connections.DriverConnection;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Hooks.java - Suite initializer and terminator class
 *
 * @author Shiwantha Lakmal
 * @version 1.0-SNAPSHOT Last modified 11_23_2015
 * @since 04/20/2015.
 */
public class Hooks {

    final static Logger log = Logger.getLogger(Hooks.class);
    public static RemoteWebDriver driver;

    @BeforeClass
    public void suiteInitiate(){
    }

    @Before
    public void testInitiate(){
        driver = DriverConnection.getDeriverInstance();
        log.info("[NOTE]: Initiate Driver Connection...");
    }

    @After
    public void testTerminate(Scenario scenario){
        if (scenario.isFailed()){
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }catch (WebDriverException ex) {
                log.error("[NOTE]: Error Occurred ! "+ex.getMessage());
            }
        }
        DriverConnection.closeDriver();
        log.info("[NOTE]: Terminate Driver Connection...");
    }

    @AfterClass
    public void suiteTerminate(){
    }
}
