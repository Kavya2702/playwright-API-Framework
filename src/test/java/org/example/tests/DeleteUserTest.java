package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.BaseTest;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest extends BaseTest {



    @Test
    public void deleteUser() {

        APIResponse response =
                ApiClient.delete(ApiEndpoints.USERS + "/2");

        logger.info("Status Code : {}", response.status());

        Assert.assertEquals(response.status(), 204);
    }
}