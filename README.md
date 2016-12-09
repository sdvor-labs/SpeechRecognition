# Speech recognition library

[ ![Download](https://api.bintray.com/packages/sdvor/Android/speech-recognition/images/download.svg) ](https://bintray.com/sdvor/Android/speech-recognition/_latestVersion)

## Setup

 Provide the gradle dependency

 `compile 'com.github.sdvor-labs:speech-recognition:0.0.1'`

 ## Example

 `public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
  }`