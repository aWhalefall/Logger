package com.core.liblogger;

import androidx.annotation.NonNull;


public final class LogTag {
    private String tag;

    private LogTag(@NonNull String tag) {
        this.tag = tag;
    }

    public static LogTag mk(@NonNull String tag) {
        return new LogTag(tag);
    }

    public String gTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
