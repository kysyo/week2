package com.assignmentwebflux.week2;

import java.util.HashMap;
import java.util.Map;

public class HelloData {

    String to;
    String message;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    String job;

    public HelloData(String to, String message, String job){
        this.to = to;
        this.message = message;
        this.job = job;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
