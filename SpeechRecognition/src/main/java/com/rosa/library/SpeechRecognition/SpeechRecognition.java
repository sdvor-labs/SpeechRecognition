package com.rosa.library.SpeechRecognition;

import android.app.Activity;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Speech recognition on based RecognizerIntent.
 * Created by karbunkul on 07.12.2016.
 */
public class SpeechRecognition {

    private Activity mActivity;
    private int mReqCode;
    private String mPrompt;

    /**
     * Constructor.
     *
     * @param activity - activity.
     * @param reqCode  - request code.
     */
    public SpeechRecognition(Activity activity, int reqCode) {
        setReqCode(reqCode);
        setActivity(activity);
    }

    /**
     * Get new instance SpeechRecognition.
     *
     * @param activity - activity.
     * @param reqCode  - request code.
     * @return this.
     */
    public static SpeechRecognition newInstance(AppCompatActivity activity, int reqCode) {
        return new SpeechRecognition(activity, reqCode);
    }

    /**
     * Show RecognizerIntent.
     */
    public void speechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        if (getPrompt() != null && !getPrompt().equals("")) {
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getPrompt());
        }
        if (getActivity() != null) {
            getActivity().startActivityForResult(intent, getReqCode());
        }
    }

    /**
     * Get resulted text.
     *
     * @param requestCode - request code.
     * @param resultCode  - result code.
     * @param data        - intent data
     * @return result texta.
     */
    public String getResultedText(int requestCode, int resultCode, Intent data) {
        String resultedText = "";
        if (requestCode == getReqCode() && resultCode == Activity.RESULT_OK && null != data) {
            ArrayList<String> result = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            resultedText = result.get(0);
        }
        return resultedText;
    }

    /**
     * Get activity.
     *
     * @return activity.
     */
    private Activity getActivity() {
        return mActivity;
    }

    /**
     * Set activity.
     *
     * @param activity - activity.
     */
    private void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    /**
     * Get request code for startActivityForResult.
     *
     * @return Request code.
     */
    private int getReqCode() {
        return mReqCode;
    }

    /**
     * Get request code for startActivityForResult.
     *
     * @param reqCode - request code.
     */
    private void setReqCode(int reqCode) {
        this.mReqCode = reqCode;
    }

    /**
     * Get prompt message in RecognizerIntent dialog.
     *
     * @return Prompt message.
     */
    private String getPrompt() {
        return mPrompt;
    }

    /**
     * Set prompt message
     *
     * @param prompt - prompt message.
     * @return this.
     */
    public SpeechRecognition setPrompt(String prompt) {
        this.mPrompt = prompt;
        return this;
    }
}
