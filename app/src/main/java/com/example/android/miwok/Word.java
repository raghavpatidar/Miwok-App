package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private  int mImaggeResourceId;

    public Word(String defaultTranslation, String miwokTranslation , int imageRescourceId)
    {

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImaggeResourceId  =imageRescourceId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    public int getImage(){
        return mImaggeResourceId;
    }

}
