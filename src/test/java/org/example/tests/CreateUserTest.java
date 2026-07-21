package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.example.base.BaseTest;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.example.dataprovider.UserDataProvider;
import org.example.models.UserRequest;
import org.example.models.UserResponse;
import org.example.utils.JsonUtils;
import org.testng.annotations.Test;
import org.example.validators.ResponseValidator;

public class CreateUserTest extends BaseTest {
    @Test(dataProvider = "userData",
            dataProviderClass = UserDataProvider.class)

    public void createUser(String name, String job) {
        UserRequest request =
                new UserRequest(name, job);



        APIResponse response =
                ApiClient.post(ApiEndpoints.USERS, request);


        UserResponse userResponse =
                JsonUtils.fromJson(response.text(), UserResponse.class);

        logger.info("Status Code : {}", response.status());
        logger.info("Response : {}", userResponse);

        ResponseValidator.validateStatus(response, 201);

        ResponseValidator.validateUser(
                userResponse,
                "Kaviya",
                "QA Engineer"
        );
    }
}