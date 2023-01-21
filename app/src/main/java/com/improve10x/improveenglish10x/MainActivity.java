package com.improve10x.improveenglish10x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import com.improve10x.improveenglish10x.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleGenerateBtn();
    }

    private void handleGenerateBtn() {
        binding.generateBtn.setOnClickListener(v -> {
            generateSentence();
        });
    }

    private void generateSentence() {
        if(!isValidInformation()) return;
        RadioButton selectedSubject = findViewById(binding.subjectRg.getCheckedRadioButtonId());
        String subject = selectedSubject.getText().toString();
        String verbOrAction = binding.verbOrActionLayout.getEditText().toString();
        String objectText = binding.objectLayout.getEditText().getText().toString();
        RadioButton selectedTense = findViewById(binding.tenseRg.getCheckedRadioButtonId());
        String tense = selectedTense.getText().toString();
        Boolean isPositive = binding.positiveSwitch.isChecked();
        String sentence = SentenceUtil.generateSentence(subject,
                verbOrAction, objectText, tense, isPositive);
        binding.sentenseTxt.setText(sentence);
    }

    private boolean isValidInformation() {
        if(binding.subjectRg.getCheckedRadioButtonId() == -1) {
            toast("Please select the subject I / We / Code");
            return false;
        }
        if(binding.tenseRg.getCheckedRadioButtonId() == -1) {
            toast("Please select the tense Past/Present/Future");
            return false;
        }
        if(binding.verbOrActionLayout.getEditText().getText().toString().trim().isEmpty()) {
            toast("Please enter the Verb/Action word");
            return false;
        }
        if(binding.objectLayout.getEditText().getText().toString().trim().isEmpty()) {
            toast("Please enter the object word");
            return false;
        }
        return true;
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}