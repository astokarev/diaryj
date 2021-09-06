package com.example.diaryj;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    EditText editText;
    Button button;
    LinearLayout noteList;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        editText.setBreakStrategy(LineBreaker.BREAK_STRATEGY_SIMPLE);

        button = findViewById(R.id.button);
        button.setEnabled(false);
        noteList = findViewById(R.id.noteList1);
        button.setOnClickListener(this);
        editText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                TextView note = new TextView(this);
                Date date = new Date();
                noteList.addView(note);
                note.setText(date.toString()+" "+ editText.getText());
                editText.getText().clear();
            case R.id.editText:
                button.setEnabled(true);
        }
    }
}