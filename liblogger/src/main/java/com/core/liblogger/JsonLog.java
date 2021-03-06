package com.core.liblogger;



import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * author: yangweichao
 * time: 2019/6/24
 * descript:
 */
public final class JsonLog {
    private static final int JSON_INDENT = 4; //缩进
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");//行分隔

    public static void printJson(@NonNull LogTag tag, @NonNull String headString, @NonNull String msg) {
        String message;
        try {
            String str = checkStartChar(msg);
            if (str.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(JSON_INDENT);
                message = "\n" + message;
            } else if (str.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(JSON_INDENT);
                message = "\n" + message;
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }
        BaseLog.printLine(LogType.JSON, tag, true);
        message = headString + LINE_SEPARATOR + message;
        String[] lines = message.split(LINE_SEPARATOR);
        for (String line : lines) {
            if (!BaseLog.isEmpty(line)) {
                BaseLog.printSub(LogType.JSON, tag, "║ " + line);
            }
        }
        BaseLog.printLine(LogType.JSON, tag, false);
    }

    private static String checkStartChar(@NonNull String msg) {
        if (msg.startsWith("\n") || msg.startsWith("\t")) {
            return checkStartChar(msg.substring(1, msg.length()));
        }
        return msg;
    }
}