package org.example.utils;

import org.example.config.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class HeaderManager {

    public static Map<String, String> getDefaultHeaders() {

        Map<String, String> headers = new HashMap<>();

        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", ConfigReader.getProperty("api.key"));

        return headers;
    }
}