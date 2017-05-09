package com.example.ajmalsyed.miwok;

/**
 * Created by Ajmal Syed on 1/26/2017.
 */
public class Colors {
    private String mMiwoktranslate;
    private String mDefaulttranslate;
    private int mImageId;
    private int mMusic;

    public Colors(String mMiwoktranslate,String mDefaulttranslate,int mImageId,int mMusic){
        this.mMiwoktranslate=mMiwoktranslate;
        this.mDefaulttranslate=mDefaulttranslate;
        this.mImageId=mImageId;
        this.mMusic=mMusic;
    }
    public String getmMiwoktranslate(){
        return mMiwoktranslate;
    }
    public String getmDefaulttranslate(){
        return mDefaulttranslate;
    }
    public int getmImageId(){
        return mImageId;
    }
    public int getmMusic(){
        return mMusic;
    }

}
