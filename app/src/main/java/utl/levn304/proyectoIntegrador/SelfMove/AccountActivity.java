package utl.levn304.proyectoIntegrador.SelfMove;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_settings);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                startActivity(new android.content.Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.navigation_search) {
                startActivity(new android.content.Intent(this, RoutesActivity.class));
                return true;
            } else if (id == R.id.navigation_card) {
                startActivity(new android.content.Intent(this, PagoBusActivity.class));
                return true;
            } else if (id == R.id.navigation_notifications) {
                startActivity(new android.content.Intent(this, NotificationsActivity.class));
                return true;
            } else if (id == R.id.navigation_settings) {
                recreate();
                return true;
            }
            return false;
        });
    }
} 