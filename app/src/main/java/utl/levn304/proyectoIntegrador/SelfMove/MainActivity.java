package utl.levn304.proyectoIntegrador.SelfMove;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                recreate(); // Refresca la actividad actual
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
                startActivity(new android.content.Intent(this, AccountActivity.class));
                return true;
            }
            return false;
        });
    }
}