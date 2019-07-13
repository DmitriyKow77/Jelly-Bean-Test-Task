package info.stepdefinitions;

/**
 * Created by dmitriy on 2/10/19.
 */

import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivers.utils.DriverUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {
    Logger logger = LogManager.getRootLogger();

    @Before
    public void beforeScenario(){
        logger.log(Level.INFO,"This code will run before scenario");
    }

    @After
    public void afterScenario(){
        logger.log(Level.INFO,"Test completed, closing driver");
        DriverUtil.close_driver();
    }
}