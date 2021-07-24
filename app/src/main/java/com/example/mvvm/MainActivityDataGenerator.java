package com.example.mvvm;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityDataGenerator extends ViewModel {

    private String TAG = this.getClass().getSimpleName();
    private String myRandomNumber;

    public String getNumber() {
        Log.i(TAG, "Get number");
        if(myRandomNumber ==null)
        {
            createNumber();
        }
        return myRandomNumber;
    }

    private void createNumber() {
        Log.i(TAG, "Create new number");
        Random random = new Random();
        myRandomNumber = "Number: " + (random.nextInt(10 - 1) + 1);
    }
}