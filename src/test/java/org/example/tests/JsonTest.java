package org.example.tests;

import org.example.models.UserRequest;
import org.example.utils.JsonUtils;
import org.testng.annotations.Test;

public class JsonTest {

    @Test
    public void convertObjectToJson() {

        UserRequest request = new UserRequest("Kaviya", "QA");

        String json = JsonUtils.toJson(request);

        System.out.println(json);
    }
}