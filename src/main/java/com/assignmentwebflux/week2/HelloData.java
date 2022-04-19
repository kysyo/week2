package com.assignmentwebflux.week2;

import java.util.HashMap;
import java.util.Map;

public class HelloData {

    String to;
    String message;

    public HelloData(String to, String message){
        this.to = to;
        this.message = message;
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
