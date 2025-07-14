package utl.levn304.proyectoIntegrador.SelfMove;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        ImageButton btnBack = findViewById(R.id.btnBack);
        EditText etPin1 = findViewById(R.id.etPin1);
        EditText etPin2 = findViewById(R.id.etPin2);
        EditText etPin3 = findViewById(R.id.etPin3);
        EditText etPin4 = findViewById(R.id.etPin4);
        View btnContinue = findViewById(R.id.btnContinue);
        View tvResend = findViewById(R.id.tvResend);
        TextView tvInstruction = findViewById(R.id.tvVerificationInstruction);

        String email = getIntent().getStringExtra("email");
        if (email != null && !email.isEmpty()) {
            String text = "El código de verificación ha sido enviado a tu correo " + email;
            tvInstruction.setText(text);
        } else {
            tvInstruction.setText("El código de verificación ha sido enviado a tu correo");
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VerificationActivity.this, "Código reenviado (demo)", Toast.LENGTH_SHORT).show();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pin1 = etPin1.getText().toString().trim();
                String pin2 = etPin2.getText().toString().trim();
                String pin3 = etPin3.getText().toString().trim();
                String pin4 = etPin4.getText().toString().trim();
                if (TextUtils.isEmpty(pin1) || TextUtils.isEmpty(pin2) || TextUtils.isEmpty(pin3) || TextUtils.isEmpty(pin4)) {
                    Toast.makeText(VerificationActivity.this, "Completa el código de verificación", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Aquí iría la lógica real de verificación
                // Redirigir a MainActivity
                Intent intent = new Intent(VerificationActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
} 