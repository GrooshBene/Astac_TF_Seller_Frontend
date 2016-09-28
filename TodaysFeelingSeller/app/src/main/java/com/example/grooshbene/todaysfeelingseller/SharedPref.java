package com.example.grooshbene.todaysfeelingseller;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by GrooshBene on 2016. 9. 29..
 */
public class SharedPref {
    Context context;
    String name;
    SharedPref (Context context, String name) {
        this.context=context;
        this.name=name;
    }

    public void put(String key, String value) {
        SharedPreferences pref=context.getSharedPreferences(name, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(key,value);
        editor.commit();
    }

    public void put(String key, int value) {
        SharedPreferences pref=context.getSharedPreferences(name, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt(key, value);
        editor.commit();
    }

    public void put(String key, long value) {
        SharedPreferences pref=context.getSharedPreferences(name, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putLong(key, value);
        editor.commit();
    }

    public void put(String key, boolean value) {
        SharedPreferences pref=context.getSharedPreferences(name, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean(key, value);
        editor.commit();
    }

    public void put(String key, float value) {
        SharedPreferences pref=context.getSharedPreferences(name, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putFloat(key, value);
        editor.commit();
    }
    public String get(String key, String defvalue) {
        SharedPreferences pref=context.getSharedPreferences(name,Activity.MODE_PRIVATE);
        return pref.getString(key,defvalue);
    }

    public int get(String key, int defvalue) {
        SharedPreferences pref=context.getSharedPreferences(name, Activity.MODE_PRIVATE);
        return pref.getInt(key,defvalue);
    }

    public long get(String key, long defvalue) {
        SharedPreferences pref=context.getSharedPreferences(name,Activity.MODE_PRIVATE);
        return pref.getLong(key,defvalue);
    }

    public boolean get(String key, boolean defvalue) {
        SharedPreferences pref=context.getSharedPreferences(name,Activity.MODE_PRIVATE);
        return pref.getBoolean(key,defvalue);
    }

    public float get(String key, float defvalue) {
        SharedPreferences pref=context.getSharedPreferences(name,Activity.MODE_PRIVATE);
        return pref.getFloat(key,defvalue);
    }
}
