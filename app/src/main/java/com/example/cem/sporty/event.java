package com.example.cem.sporty;
import java.util.*;
/**
 * Created by balpy on 16.11.2017.
 * Class for event object
 */

public class event {
    public int event_id;
    public String event_type;
    public int creator; // unique user_id, points to owner of the event.
    public String location;
    public long date_time;
    public int max_participants;
    public int[] curr_participants;

    public event(int event_id, String event_type, int creator, String location, long date_time, int max_participants, int[] curr_participants) {
        this.event_id = event_id;
        this.event_type = event_type;
        this.creator = creator;
        this.location = location;
        this.date_time = date_time;
        this.max_participants = max_participants;
        this.curr_participants = curr_participants;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getDate_time() {
        return date_time;
    }

    public void setDate_time(long date_time) {
        this.date_time = date_time;
    }

    public int getMax_participants() {
        return max_participants;
    }

    public void setMax_participants(int max_participants) {
        this.max_participants = max_participants;
    }

    public int[] getCurr_participants() {
        return curr_participants;
    }

    public void setCurr_participants(int[] curr_participants) {
        this.curr_participants = curr_participants;
    }
}
