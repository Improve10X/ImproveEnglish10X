package com.improve10x.improveenglish10x;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.firestore.FirebaseFirestore;
import com.improve10x.improveenglish10x.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private SentenceUtil sentenceUtil = new SentenceUtil();
    private ActivityMainBinding binding;
    private FirebaseAnalytics analytics;
    private FirebaseCrashlytics crashlytics;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        analytics = FirebaseAnalytics.getInstance(this);
        crashlytics = FirebaseCrashlytics.getInstance();
        getSupportActionBar().setTitle("Improve English 10X");
        progress = new ProgressDialog(this);
        handleGenerateBtn();
        handleLevel1Btn();
        handleLevel2Btn();
        fetchPastVerbs();
        fetchSuggestions();
    }

    private void showProgress() {
        if(!progress.isShowing()) {
            progress.show();
        }
    }

    private void hideProgress() {
        if(progress.isShowing()) {
            progress.hide();
        }
    }

    private void fetchPastVerbs() {
        if(SentenceUtil.pastVerbs != null && !SentenceUtil.pastVerbs.isEmpty()) return;
        showProgress();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("/tenses")
                .document("/pastVerbs")
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    hideProgress();
                    SentenceUtil.pastVerbs = documentSnapshot.getData();
                })
                .addOnFailureListener(e -> {
                    hideProgress();
                    Log.e(TAG, e.getMessage(), e);
                });
    }

    private void fetchSuggestions() {
        if(SentenceUtil.suggestionVerbs != null && SentenceUtil.suggestionVerbs.length != 0) return;
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("/suggestions")
                .document("/verbs")
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    SentenceUtil.suggestionVerbs = documentSnapshot.get("data", String[].class);
                })
                .addOnFailureListener(e -> {
                    Log.e(TAG, e.getMessage(), e);
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        toast("Logged out successfully");
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                    }
                });
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
        if (!isValidInformation()) return;
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
        logSentence(sentence);
    }

    private void logSentence(String sentence) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        analytics.setUserId(user.getUid());
        analytics.setUserProperty("name", user.getDisplayName());
        analytics.setUserProperty("email", user.getEmail());
        analytics.setUserProperty("phone", user.getPhoneNumber());
        Bundle bundle = new Bundle();
        bundle.putString("sentence", sentence);
        analytics.logEvent("SentenceGenerated", bundle);
    }

    private boolean isValidInformation() {
        if (binding.subjectRg.getCheckedRadioButtonId() == -1) {
            toast("Please select the subject I / We / Code");
            return false;
        }
        if (binding.tenseRg.getCheckedRadioButtonId() == -1) {
            toast("Please select the tense Past/Present/Future");
            return false;
        }
        if (binding.verbOrActionLayout.getEditText().getText().toString().trim().isEmpty()) {
            toast("Please enter the Verb/Action word");
            return false;
        }
        return true;
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}