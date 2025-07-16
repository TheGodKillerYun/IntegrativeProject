package utl.levn304.proyectoIntegrador.SelfMove;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RoutesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_search);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                startActivity(new android.content.Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.navigation_search) {
                recreate();
                return true;
            } else if (id == R.id.navigation_card) {
                startActivity(new android.content.Intent(this, PagoBusActivity.class));
                return true;
            } else if (id == R.id.navigation_notifications) {
                startActivity(new android.content.Intent(this, NotificationsActivity.class));
                return true;
            } else if (id == R.id.navigation_settings) {
                startActivity(new android.content.Intent(this, AccountActivity.class));
                return true;
            }
            return false;
        });
    }
} 