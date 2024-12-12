package com.sts.testautomation.utilities;

import com.sts.testautomation.core.pages.BasePage;

import java.util.Observable;
import java.util.Observer;

public class FailureUtil {

    private boolean isFailed = false;
    private int rowIndex;
    private String date;
    private String time;
    private String description;
    private String error;
    private String message;

    public FailureUtil(
            boolean isFailed,
            int rowIndex,
            String date,
            String time,
            String description,
            String error,
            String message
    ) {

        this.isFailed = isFailed;
        this.rowIndex = rowIndex;
        this.date = date;
        this.time = time;
        this.description = description;
        this.error = error;
        this.message = message;
    }

    public boolean isFailed() {
        return isFailed;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
