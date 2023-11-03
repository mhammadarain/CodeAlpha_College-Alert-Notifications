package com.example.unialertnotifications; // Update this package name accordingly

import java.util.Date;

import java.io.Serializable;
public class CustomEvent implements Serializable {
    private String eventName;
    private Date eventDate;

    public CustomEvent(String eventName, Date eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    // Other methods and fields for your CustomEvent class...
}
