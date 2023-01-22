package com.improve10x.improveenglish10x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.improve10x.improveenglish10x.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private SentenceUtil sentenceUtil = new SentenceUtil();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleGenerateBtn();
        handleLevel1Btn();
        handleLevel2Btn();
    }

    private void handleGenerateBtn() {
        binding.generateBtn.setOnClickListener(v -> {
            generateSentence();
        });
    }

    private void handleLevel1Btn() {
        binding.level1Btn.setOnClickListener(v -> {
            binding.iRb.setVisibility(View.VISIBLE);
            binding.weRb.setVisibility(View.VISIBLE);
            binding.heRb.setVisibility(View.GONE);
            binding.sheRb.setVisibility(View.GONE);
            binding.itRb.setVisibility(View.GONE);
            binding.theyRb.setVisibility(View.GONE);
        });
    }

    private void handleLevel2Btn() {
        binding.level2Btn.setOnClickListener(v -> {
            binding.iRb.setVisibility(View.GONE);
            binding.weRb.setVisibility(View.GONE);
            binding.heRb.setVisibility(View.VISIBLE);
            binding.sheRb.setVisibility(View.VISIBLE);
            binding.itRb.setVisibility(View.VISIBLE);
            binding.theyRb.setVisibility(View.VISIBLE);
        });
    }

    private void generateSentence() {
        if(!isValidInformation()) return;
        RadioButton selectedSubject = findViewById(binding.subjectRg.getCheckedRadioButtonId());
        String subject = selectedSubject.getText().toString();
        String verbOrAction = binding.verbOrActionLayout.getEditText().getText().toString();
        String objectText = binding.objectLayout.getEditText().getText().toString();
        RadioButton selectedTense = findViewById(binding.tenseRg.getCheckedRadioButtonId());
        String tense = selectedTense.getText().toString();
        Boolean isPositive = binding.positiveSwitch.isChecked();
        String sentence = sentenceUtil.generateSentence(subject,
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
        return true;
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}