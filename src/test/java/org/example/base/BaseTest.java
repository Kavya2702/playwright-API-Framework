package org.example.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    protected Logger logger =
            LogManager.getLogger(getClass());

    @BeforeMethod
    public void beforeTest(Method method) {

        logger.info("========================================");
        logger.info("Starting Test : {}", method.getName());
        logger.info("========================================");
    }

    @AfterMethod
    public void afterTest(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {

            logger.info("PASSED : {}", result.getName());

        } else if (result.getStatus() == ITestResult.FAILURE) {

            logger.error("FAILED : {}", result.getName());

        } else {

            logger.warn("SKIPPED : {}", result.getName());
        }

        logger.info("========================================");
    }
}