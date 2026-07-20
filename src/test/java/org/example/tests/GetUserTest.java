package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.example.models.UserResponse;
import org.example.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserTest {
    private static final Logger logger =
            LogManager.getLogger(CreateUserTest.class);

    @Test
    public void getSingleUser() {

        APIResponse response = ApiClient.get(ApiEndpoints.USERS + "/2");
        UserResponse userResponse =
                JsonUtils.fromJson(response.text(), UserResponse.class);

        logger.info("Status Code : {}", response.status());
        logger.info("Response : {}", userResponse);

        Assert.assertEquals(response.status(), 200);
    }
}