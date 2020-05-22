package id.amin_syifa.dgreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
  private SessionHandler session;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dashboard);
    session = new SessionHandler(getApplicationContext());
    User user = session.getUserDetails();
    TextView welcomeText = findViewById(R.id.welcomeText);

    welcomeText.setText("Welcome "+user.getFullname()+", Your session will expire on"+user.getSessionExpiryDate());

    Button logoutBtn = findViewById(R.id.btnLogout);
    logoutBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        session.logoutUser();
        Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
        startActivity(i);
        finish();

      }

    });

    Button barangBtn = findViewById(R.id.btnBarang);
    barangBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(DashboardActivity.this, tambahActivity.class);
        startActivity(i);
        finish();
      }
    });
  }

}