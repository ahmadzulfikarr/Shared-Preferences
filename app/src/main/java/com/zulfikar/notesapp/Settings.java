package com.zulfikar.notesapp;

import android.content.Context;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

public class Settings {

    private SharedPreferences preferences;
    private String lastMode;

    public Settings(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getUser() {
        return preferences.getString(Constant.SESSION, null);
    }

    public void setUser(String user) {
        preferences.edit()
                .putString(Constant.SESSION, user)
                .apply();
    }

    public void removeUser() {
        preferences.edit()
                .remove(Constant.SESSION)
                .apply();
    }

    public int getLayoutMode() {
        return preferences.getInt(Constant.LAYOUT_MODE, Constant.LAYOUT_MODE_LIST);
    }

    public void setLayoutMode(int layout) {
        preferences.edit()
                .putInt(Constant.LAYOUT_MODE, layout)
                .apply();
    }

    public float getTextSize() {
        String textSize = preferences.getString(Constant.PREF_TEXT_SIZE, "20");
        return Float.parseFloat(textSize);
    }

    public String getTextColor(){
        String textSize = preferences.getString(Constant.PREF_COLOR_MODE, "#000000");
        return textSize;
    }

    public String getColorMode(){
        String color = preferences.getString(Constant.PREF_COLOR_MODE,"light");
        return color;
    }

    public void setColorMode(String color){
        preferences.edit()
                .putString(Constant.PREF_COLOR_MODE,color)
                .apply();
    }


    public String getListMode(){
        return preferences.getString(lastMode,"list");
    }

    public void setListMode(String last){
        preferences.edit()
                .putString(lastMode,last)
                .apply();
    }
}