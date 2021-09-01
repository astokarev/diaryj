package com.example.diaryj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    EditText editText;
    Button button;
    LinearLayout llMain;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        llMain = findViewById(R.id.llMain);
        button.setOnClickListener(this);
        LinearLayout llMain = new LinearLayout(this);
        TextView gen = new TextView(this);
    }
    @Override
    public void onClick(View v) {
        TextView gen = new TextView(this);
        llMain.addView(gen);
        gen.setText(editText.getText());
    }
}