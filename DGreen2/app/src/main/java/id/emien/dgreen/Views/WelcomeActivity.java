package id.emien.dgreen.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.emien.dgreen.R;
import id.emien.dgreen.adapter.welcomeAdapter;

public class WelcomeActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ImageView[] indicators = new ImageView[3];

    private void setIndicators(){
        indicators[0] = findViewById(R.id.indicator1);
        indicators[1] = findViewById(R.id.indicator2);
        indicators[2] = findViewById(R.id.indicator3);
    }

    private void setIndicatorImage(int position){
        int iconWhite = R.drawable.ic_indicator_white;
        int iconGrey = R.drawable.ic_indicator_grey;
        indicators[0].setImageResource(position == 0 ? iconWhite : iconGrey);
        indicators[1].setImageResource(position == 1 ? iconWhite : iconGrey);
        indicators[2].setImageResource(position == 2 ? iconWhite : iconGrey);
    }

    private void setViewPager(){
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new welcomeAdapter(this));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                setIndicatorImage(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setIndicatorImage(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanseState){
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_welcome);
        setIndicators();
        setViewPager();

        //Tombol Button LOGIN SEKARANG
        Button loginNow = findViewById(R.id.btn_login_now);
        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
            }
        });
    }
}
