package org.example.client;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.example.config.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class ApiClient {

    private static final Playwright playwright = Playwright.create();
    private static final APIRequestContext requestContext;

    static {

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", ConfigReader.getProperty("api.key"));

        requestContext = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setIgnoreHTTPSErrors(true)
                        .setExtraHTTPHeaders(headers)
        );
    }

    public static APIResponse get(String endpoint) {

        String url = ConfigReader.getProperty("base.url") + endpoint;

        System.out.println("GET : " + url);

        return requestContext.get(url);
    }
}