package utl.levn304.proyectoIntegrador.SelfMove;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import utl.levn304.proyectoIntegrador.R;

public class UbicacionesFavoritasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones_favoritas);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Regresa a la pantalla anterior
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(this, MainActivity.class));
                    return true;
                case R.id.navigation_search:
                    // Agrega aquí la Activity correspondiente si existe
                    return true;
                case R.id.navigation_chat:
                    startActivity(new Intent(this, ChatAsesorActivity.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(this, NotificationsActivity.class));
                    return true;
                case R.id.navigation_settings:
                    // Agrega aquí la Activity correspondiente si existe
                    return true;
            }
            return false;
        });
    }
} 