package com.improve10x.improveenglish10x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.improveenglish10x.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
    }

    private void generateSentence() {

    }
}