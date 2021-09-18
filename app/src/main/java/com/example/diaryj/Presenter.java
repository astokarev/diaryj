package com.example.diaryj;

import android.widget.TextView;

public class Presenter {
    private Model model;
    private View view;

    Presenter(View view){
        this.model = new Model();

        this.view = view;
    }
    public void onSaveClick(String note) {
        model.addNote(note);
        view.addNote2List(model.getNote());
        view.clearInput();
    }
}
