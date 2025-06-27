package utl.levn304.proyectoIntegrador.SelfMove;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RecoverPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        TextInputEditText etEmail = findViewById(R.id.etRecoverPasswordEmail);
        MaterialButton btnReady = findViewById(R.id.btnReady);
        ImageButton btnBack = findViewById(R.id.btnBack);

        btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Ingresa tu correo electrónico");
                    return;
                }
                // Aquí iría la lógica real de recuperación de contraseña
                Toast.makeText(RecoverPasswordActivity.this, "Correo para restablecer contraseña enviado (demo)", Toast.LENGTH_LONG).show();
                // Redirigir a la pantalla de verificación de contraseña
                Intent intent = new Intent(RecoverPasswordActivity.this, PasswordVerificationActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
} 