package utl.levn304.proyectoIntegrador.SelfMove;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import utl.levn304.proyectoIntegrador.SelfMove.R;

public class AyudaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        ImageButton btnBack = findViewById(R.id.btnBack);
        ImageButton btnBack2 = findViewById(R.id.btnBack2);
        View.OnClickListener backListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        };
        btnBack.setOnClickListener(backListener);
        btnBack2.setOnClickListener(backListener);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.navigation_dashboard) {
                // Navegación a Dashboard si existe
                return true;
            } else if (id == R.id.navigation_notifications) {
                startActivity(new Intent(this, NotificationsActivity.class));
                return true;
            } else if (id == R.id.navigation_settings) {
                // Navegación a Settings si existe
                return true;
            }
            return false;
        });
    }
} 