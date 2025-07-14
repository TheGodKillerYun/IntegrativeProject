package utl.levn304.proyectoIntegrador.SelfMove;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import android.widget.ImageButton;

public class NewPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        TextInputEditText etCodePassword = findViewById(R.id.etCodePassword);
        TextInputEditText etNewPassword = findViewById(R.id.etNewPassword);
        TextInputEditText etConfirmPassword = findViewById(R.id.etConfirmPassword);
        MaterialButton btnReady = findViewById(R.id.btnReady);
        ImageButton btnBack = findViewById(R.id.btnBack);

        btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codePassword = etCodePassword.getText() != null ? etCodePassword.getText().toString().trim() : "";
                String newPassword = etNewPassword.getText() != null ? etNewPassword.getText().toString().trim() : "";
                String confirmPassword = etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString().trim() : "";
                if (TextUtils.isEmpty(codePassword)) {
                    etCodePassword.setError("Ingresa la contraseña recibida");
                    return;
                }
                if (TextUtils.isEmpty(newPassword)) {
                    etNewPassword.setError("Ingresa tu nueva contraseña");
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    etConfirmPassword.setError("Confirma tu nueva contraseña");
                    return;
                }
                if (!newPassword.equals(confirmPassword)) {
                    etConfirmPassword.setError("Las contraseñas no coinciden");
                    return;
                }
                // Aquí iría la lógica real de cambio de contraseña
                Toast.makeText(NewPasswordActivity.this, "Contraseña cambiada exitosamente (demo)", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(NewPasswordActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
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