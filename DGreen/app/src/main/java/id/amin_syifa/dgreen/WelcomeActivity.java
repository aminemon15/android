package id.amin_syifa.dgreen;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.amin_syifa.dgreen.adapter.WelcomeAdapter;

public class WelcomeActivity extends AppCompatActivity {

  private ViewPager viewPager;
  private ImageView[] indicators = new ImageView[3];

  private void setIndicators() {
    indicators[0] = findViewById(R.id.indicator1);
    indicators[1] = findViewById(R.id.indicator2);
    indicators[2] = findViewById(R.id.indicator3);
  }

  private void setIndicatorImage(int position){
    int iconWhite = R.drawable.ic_indicator_white;
    int iconGrey = R.drawable.ic_indicator_grey;
    indicators[0].setImageResource(position == 0 ? iconWhite :iconGrey);
    indicators[1].setImageResource(position == 1 ? iconWhite :iconGrey);
    indicators[2].setImageResource(position == 2 ? iconWhite :iconGrey);
  }

  private void setViewPager(){
    viewPager = findViewById(R.id.viewpager);
    viewPager.setAdapter(new WelcomeAdapter(this));
    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int i, float v, int il) {

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
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);
    setIndicators();
    setViewPager();

    //Tombol Masuk sekarang
    Button orderNow = findViewById(R.id.btn_order_now);
    orderNow.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
      }
    });
  }
}