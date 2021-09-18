package com.example.diaryj;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener, com.example.diaryj.View {
    private Presenter presenter = new Presenter(this);
    EditText editText;
    Button saveButton;
    LinearLayout noteList;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        editText.setBreakStrategy(LineBreaker.BREAK_STRATEGY_SIMPLE);
        saveButton = findViewById(R.id.saveButton);
        saveButton.setEnabled(false);
        noteList = findViewById(R.id.noteCntnr);
        saveButton.setOnClickListener(this);
        editText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveButton:
                String noteText = editText.getText().toString();
                presenter.onSaveClick(noteText);
            case R.id.editText:
                saveButton.setEnabled(true);
        }

    }

    @Override
    public void addNote2List(String noteText) {
        TextView note = new TextView(this);
        noteList.addView(note);
        note.setText(Html.fromHtml(noteText));
    }

    @Override
    public void clearInput() {
        editText.getText().clear();
    }
}