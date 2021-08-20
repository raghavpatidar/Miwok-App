package com.example.android.miwok;

public class Wordphrases {

    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Wordphrases(String defaultTranslation, String miwokTranslation)
    {

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

}
