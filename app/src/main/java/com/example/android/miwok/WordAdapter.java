package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;


    public  WordAdapter(Activity context , ArrayList<Word>words , int colorResourceId) {
        super(context , 0 , words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemview = convertView;
        if(listItemview == null)
        {
            listItemview = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view ,parent , false);
        }
        Word current_item = getItem(position);
        TextView default_item = (TextView)listItemview.findViewById(R.id.default_text_view);
        TextView miwok_item = (TextView)listItemview.findViewById(R.id.miwok_text_view);
        ImageView image = (ImageView)listItemview.findViewById(R.id.image);

        default_item.setText(current_item.getDefaultTranslation());
        miwok_item.setText(current_item.getMiwokTranslation());
        image.setImageResource(current_item.getImage());

        View textXonatiner = listItemview.findViewById(R.id.linear_layout);
        int color = ContextCompat.getColor(getContext() , mColorResourceId);
        textXonatiner.setBackgroundColor(color);



        return listItemview;

    }


}
