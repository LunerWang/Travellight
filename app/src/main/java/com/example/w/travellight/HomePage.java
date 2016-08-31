package com.example.w.travellight;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class HomePage extends Activity {

    private ImageButton community;
    private ImageButton person_center;
    private ImageButton home_page;
    private EditText sear_text;
    private ImageButton search_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);




    }
}
