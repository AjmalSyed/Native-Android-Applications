package com.example.ajmalsyed.miwok;

/**
 * Created by Ajmal Syed on 1/23/2017.
 */
public class words  {
    private String mMiwoktranslate;
    private String mDefaulttranslate;
    private int mImageId;
    private int mMusic;
    public words(String mMiwoktranslate, String mDefaulttranslate,int mImageId,int mMusic){
        this.mMiwoktranslate = mMiwoktranslate;
        this.mDefaulttranslate=mDefaulttranslate;
        this.mImageId=mImageId;
        this.mMusic=mMusic;

    }
    public int getmImageId(){
        return mImageId;
    }
    public String getmMiwoktranslate(){
        return mMiwoktranslate;

    }
    public String getmDefaulttranslate(){

        return mDefaulttranslate;
    }
    public int getmMusic(){
        return mMusic;
    }

}
