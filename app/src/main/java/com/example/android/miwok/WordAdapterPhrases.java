package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapterPhrases extends ArrayAdapter<Wordphrases> {


    public WordAdapterPhrases(Activity context , ArrayList<Wordphrases>words) {
        super(context , 0 , words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemview = convertView;
        if(listItemview == null)
        {
            listItemview = LayoutInflater.from(getContext()).inflate(
                    R.layout.word_phrases_list ,parent , false);
        }
        Wordphrases current_item = getItem(position);
        TextView default_item = (TextView)listItemview.findViewById(R.id.default_text_view_phrases);
        TextView miwok_item = (TextView)listItemview.findViewById(R.id.miwok_text_view_phrases);

        default_item.setText(current_item.getDefaultTranslation());
        miwok_item.setText(current_item.getMiwokTranslation());
        return listItemview;
    }


}
