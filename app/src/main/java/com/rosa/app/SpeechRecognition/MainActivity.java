package com.rosa.app.SpeechRecognition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rosa.library.SpeechRecognition.SpeechRecognition;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int SPEECH_RECOGNITION_REQ_CODE = 1;
    public SpeechRecognition speechRecognition;
    private TextView tvRecognitionTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRecognitionTest = (TextView) findViewById(R.id.tv_recognition_test);
        tvRecognitionTest.setOnClickListener(this);
        // Init object
        speechRecognition = SpeechRecognition.newInstance(this, SPEECH_RECOGNITION_REQ_CODE);
    }

    @Override
    public void onClick(View view) {
        // Show intent dialog.
        speechRecognition.speechInput();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Get resulted text
        tvRecognitionTest.setText(speechRecognition.getResultedText(requestCode, resultCode, data));
    }
}
