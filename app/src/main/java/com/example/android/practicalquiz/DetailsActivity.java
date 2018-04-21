package com.example.android.practicalquiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView userName, userEmail, userAbout;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Details Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userName = findViewById(R.id.name);
        userEmail = findViewById(R.id.email);
        userAbout = findViewById(R.id.about);

        getDataFromSharedPreference();
    }


    private void getDataFromSharedPreference() {
        preferences = PreferenceManager.getDefaultSharedPreferences(DetailsActivity.this);
        String name = preferences.getString("name", "Demo User");
        String email = preferences.getString("email", "demouser@demo.com");
        String about = preferences.getString("about", "This is the demo description. We will soon replace it with original data.  ");

        userName.setText(name);
        userEmail.setText(email);
        userAbout.setText(about);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return false;
    }
}
