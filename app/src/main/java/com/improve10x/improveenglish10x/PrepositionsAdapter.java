package com.improve10x.improveenglish10x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.improve10x.improveenglish10x.models.Preposition;

import java.util.List;

public class PrepositionsAdapter extends ArrayAdapter<Preposition> {
    private @LayoutRes int resource;

    public PrepositionsAdapter(@NonNull Context context, int resource, @NonNull List<Preposition> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }
        Preposition preposition = getItem(position);
        ((TextView)convertView).setText(preposition.value + " - " + preposition.teluguValue);
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }
        Preposition preposition = getItem(position);
        ((TextView)convertView).setText(preposition.value);
        return convertView;
    }
}
