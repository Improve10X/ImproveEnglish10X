package com.improve10x.improveenglish10x.models;

import java.io.Serializable;

public class ErrorReport implements Serializable {

    public String sentence;
    public String reportedBy;
    public long reportedTime;
    public String status = "TODO";

    public ErrorReport() {}

    public ErrorReport(String sentence, String reportedBy) {
        this.sentence = sentence;
        this.reportedBy = reportedBy;
        this.reportedTime = System.currentTimeMillis();
    }
}
