package com.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.List;

public class JsonUtils {
    public static final GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
    public static final Gson gson = gsonBuilder.create();

    public static String getSuccesJsonWithMessage(String message) {
        JSONObject obj = new JSONObject();
        obj.put("status", "Success");
        obj.put("message", message);
        return obj.toString();
    }

    public static String getSuccesJson(final List<?> list) {
        JSONObject obj = new JSONObject();
        obj.put("status", "Success");
        obj.put("data", new org.json.JSONArray(gson.toJson(list)));
        return obj.toString();
    }

    public static String getUnSuccesJson(String message) {
        JSONObject obj = new JSONObject();
        obj.put("status", "Fail");
        obj.put("message", message);
        return obj.toString();
    }

    public static String getSuccesJson(Object object) {
        JSONObject obj = new JSONObject();
        obj.put("status", "Success");
        obj.put("data", new JSONObject(gson.toJson(object)));
        return obj.toString();
    }


}
