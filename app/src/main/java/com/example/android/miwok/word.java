package com.example.android.miwok;

public class word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = No_Image_Provided;
    private int mResourceId;

    private static final int No_Image_Provided = -1;

    public word(String defaultTranslation, String miwokTranslation, int ResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mResourceId = ResourceId;
    }
    public word(String defaultTranslation, String miwokTranslation, int imageResouorceId, int ResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResouorceId;
        mResourceId = ResourceId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    public int getmImageResourceId() {return mImageResourceId; }
    public int getmResourceId() { return mResourceId;    }

    public boolean hasImage(){
        return mImageResourceId != No_Image_Provided;
    }
}
