package id.gresikdev.foodbank.views;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.gresikdev.foodbank.R;
import id.gresikdev.foodbank.adapter.WelcomeAdapter;


public  class WelcomeActivity extends AppCompatActivity{
    private ViewPager viewPager;

    private void setViewPager(){
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new WelcomeAdapter(this));

    }

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setViewPager();
    }
}
