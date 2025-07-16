package utl.levn304.proyectoIntegrador.SelfMove;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChangePwActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        ImageButton btnBack = findViewById(R.id.btnBack);
        EditText etCurrentPw = findViewById(R.id.etCurrentPw);
        EditText etNewPw = findViewById(R.id.etNewPw);
        EditText etRepeatNewPw = findViewById(R.id.etRepeatNewPw);
        Button btnChangePw = findViewById(R.id.btnChangePw);
        TextView tvForgotPw = findViewById(R.id.tvForgotPw);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvForgotPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a recuperación de contraseña
                Intent intent = new Intent(ChangePwActivity.this, RecoverPasswordActivity.class);
                startActivity(intent);
            }
        });

        btnChangePw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentPw = etCurrentPw.getText().toString().trim();
                String newPw = etNewPw.getText().toString().trim();
                String repeatNewPw = etRepeatNewPw.getText().toString().trim();
                if (TextUtils.isEmpty(currentPw) || TextUtils.isEmpty(newPw) || TextUtils.isEmpty(repeatNewPw)) {
                    Toast.makeText(ChangePwActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!newPw.equals(repeatNewPw)) {
                    Toast.makeText(ChangePwActivity.this, "Las contraseñas nuevas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Aquí iría la lógica real de cambio de contraseña
                Toast.makeText(ChangePwActivity.this, "Contraseña cambiada (demo)", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(this, MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(this, AccountActivity.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(this, NotificationsFragment.class));
                    return true;
                case R.id.navigation_settings:
                    // Ya estamos en configuración
                    return true;
            }
            return false;
        });
    }
} 