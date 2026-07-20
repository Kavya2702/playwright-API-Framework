package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest {

    private static final Logger logger =
            LogManager.getLogger(DeleteUserTest.class);

    @Test
    public void deleteUser() {

        APIResponse response =
                ApiClient.delete(ApiEndpoints.USERS + "/2");

        logger.info("Status Code : {}", response.status());

        Assert.assertEquals(response.status(), 204);
    }
}