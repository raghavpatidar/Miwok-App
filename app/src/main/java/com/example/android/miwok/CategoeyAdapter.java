package com.example.android.miwok;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoeyAdapter extends FragmentPagerAdapter {
    private Context mcomtext;
    public CategoeyAdapter(Context context  , FragmentManager fm) {
        super(fm);
         mcomtext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragments();
        } else if (position == 1) {
            return new FamilyFragment();
        } else if (position == 2) {
            return new ColorsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mcomtext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mcomtext.getString(R.string.category_family);
        } else if (position == 2) {
            return mcomtext.getString(R.string.category_colors);
        } else {
            return mcomtext.getString(R.string.category_phrases);
        }
    }
}
