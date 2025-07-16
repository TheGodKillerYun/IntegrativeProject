package utl.levn304.proyectoIntegrador.SelfMove;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import utl.levn304.proyectoIntegrador.SelfMove.R;

public class PagoBusActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagobus);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_card);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                startActivity(new android.content.Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.navigation_search) {
                startActivity(new android.content.Intent(this, RoutesActivity.class));
                return true;
            } else if (id == R.id.navigation_card) {
                recreate();
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