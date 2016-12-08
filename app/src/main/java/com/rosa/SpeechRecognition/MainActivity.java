package com.rosa.SpeechRecognition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rosa.library.SpeechRecognition.SpeechRecognition;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int SPEECH_RECOGNITION_REQ_CODE = 1;
    public SpeechRecognition recognizer;
    private TextView tvRecognitionTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRecognitionTest = (TextView) findViewById(R.id.tv_recognition_test);
        tvRecognitionTest.setOnClickListener(this);
        // Init object
        recognizer = SpeechRecognition.newInstance(this, SPEECH_RECOGNITION_REQ_CODE);
    }

    @Override
    public void onClick(View view) {
        // Show intent dialog.
        recognizer.speechInput();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Get resulted text
        tvRecognitionTest.setText(recognizer.getResultedText(requestCode, resultCode, data));
    }
}
