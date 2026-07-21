package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.BaseTest;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.example.models.UpdateUserRequest;
import org.example.models.UserResponse;
import org.example.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchUserTest extends BaseTest {


    @Test
    public void patchUser() {

        UpdateUserRequest request =
                new UpdateUserRequest(
                        null,
                        "Lead QA Engineer"
                );

        APIResponse response =
                ApiClient.patch(
                        ApiEndpoints.USERS + "/2",
                        request
                );
        UserResponse userResponse =
                JsonUtils.fromJson(response.text(), UserResponse.class);
        logger.info("Status Code : {}", response.status());
        logger.info("Response : {}", userResponse);

        Assert.assertEquals(response.status(), 200);
    }
}
