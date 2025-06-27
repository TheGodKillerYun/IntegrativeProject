package utl.levn304.proyectoIntegrador.SelfMove;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import android.util.Patterns;

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        TextInputEditText etFullName = findViewById(R.id.etFullName);
        TextInputEditText etEmail = findViewById(R.id.etEmail);
        TextInputEditText etPassword = findViewById(R.id.etPassword);
        CheckBox cbTerms = findViewById(R.id.cbTerms);
        MaterialButton btnSignIn = findViewById(R.id.btnSignIn);
        TextView tvGoToLogin = findViewById(R.id.tvGoToLogin);
        ImageButton btnBack = findViewById(R.id.btnBack);
        ImageButton btnFacebook = findViewById(R.id.btnFacebook);
        ImageButton btnGoogle = findViewById(R.id.btnGoogle);
        ImageButton btnApple = findViewById(R.id.btnApple);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
                String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
                String password = etPassword.getText() != null ? etPassword.getText().toString().trim() : "";
                if (TextUtils.isEmpty(fullName)) {
                    etFullName.setError("Ingresa tu nombre completo");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Ingresa tu correo electrónico");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Correo electrónico no válido");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Ingresa una contraseña");
                    return;
                }
                if (!cbTerms.isChecked()) {
                    Toast.makeText(SignInActivity.this, "Debes aceptar los términos y políticas", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Aquí iría la lógica real de registro
                Toast.makeText(SignInActivity.this, "Registro exitoso (demo)", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignInActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        tvGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, WelcomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignInActivity.this, "Registro con Facebook (no implementado)", Toast.LENGTH_SHORT).show();
            }
        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignInActivity.this, "Registro con Google (no implementado)", Toast.LENGTH_SHORT).show();
            }
        });
        btnApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignInActivity.this, "Registro con Apple (no implementado)", Toast.LENGTH_SHORT).show();
            }
        });
    }
} 