package org.marathon.code.competition.util;

import com.google.gson.Gson;

public class JsonUtil {
    private static Gson gson = new Gson();

    public static Gson getGson() {
        return gson;
    }

}
