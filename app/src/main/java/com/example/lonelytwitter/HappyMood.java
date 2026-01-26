package com.example.lonelytwitter;

import java.util.Date;

public class HappyMood extends Mood{
    public HappyMood(Date date) {
        super(date);
    }

    public HappyMood() {
        super();
    }

    @Override
    public String whatMood() {
        return "Happy";
    }
}
