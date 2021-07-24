package com.example.mvvm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNum = findViewById(R.id.btnNum);
        TextView mTextView = findViewById(R.id.tvNumber);

//        Random number value will not be retained
//        MainActivityDataGenerator myData = new MainActivityDataGenerator();
//        String myRandomNumber = myData.getNumber();

//        Random number value will be retained
        MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
//        String myRandomNumber = model.getNumber();
        LiveData<String> myRandomNumber = model.getNumber();
        Log.i(TAG, "Random Number Set");

        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTextView.setText(s);
                Log.i(TAG, "Data Updated in UI");
            }
        });

        btnNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    model.createNumber();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
    }
}