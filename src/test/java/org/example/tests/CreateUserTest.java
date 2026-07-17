package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.example.models.UserRequest;
import org.example.models.UserResponse;
import org.example.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.tests.Validators.ResponseValidator;

public class CreateUserTest {

    @Test
    public void createUser() {

        UserRequest request =
                new UserRequest("Kaviya", "QA Engineer");

        APIResponse response =
                ApiClient.post(ApiEndpoints.USERS, request);

        System.out.println("Status Code : " + response.status());
        System.out.println("Response : ");
        UserResponse userResponse =
                JsonUtils.fromJson(response.text(), UserResponse.class);

        System.out.println(userResponse);

        ResponseValidator.validateStatus(response.status(), 201);

        ResponseValidator.validateUser(
                userResponse,
                "Kaviya",
                "QA Engineer"
        );
    }
}