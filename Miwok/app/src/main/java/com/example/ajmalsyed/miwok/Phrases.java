package com.example.ajmalsyed.miwok;

/**
 * Created by Ajmal Syed on 1/26/2017.
 */
public class Phrases {
    private String mMiwoktranslate;
    private String mDefaulttranslate;
    private int mMusic;
    public Phrases(String mMiwoktranslate,String mDefaulttranslate,int mMusic){
        this.mMiwoktranslate=mMiwoktranslate;
        this.mDefaulttranslate=mDefaulttranslate;
        this.mMusic=mMusic;
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
