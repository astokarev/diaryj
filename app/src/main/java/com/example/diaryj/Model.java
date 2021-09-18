package com.example.diaryj;

import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Model {

    private String dateText;

    public void addNote(String note) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d mm yyyy HH:mm:ss");
        dateText = "<strong>"+dateFormat.format(date)+"</strong>"+" "+ note;
    }

    public String getNote() {
        return dateText;
    }
}
