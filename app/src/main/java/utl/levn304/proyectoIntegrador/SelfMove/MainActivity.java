package utl.levn304.proyectoIntegrador.SelfMove;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.gms.maps.model.CameraPosition;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar el mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        // Configurar la navegación inferior
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                // Manejar clic en Inicio
                return true;
            } else if (itemId == R.id.navigation_search) {
                // Manejar clic en Búsqueda
                return true;
            } else if (itemId == R.id.navigation_card) {
                // Manejar clic en Tarjeta
                return true;
            } else if (itemId == R.id.navigation_notifications) {
                // Manejar clic en Notificaciones
                return true;
            } else if (itemId == R.id.navigation_settings) {
                // Abrir AccountActivity
                startActivity(new Intent(this, AccountActivity.class));
                return true;
            }
            return false;
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        
        // Coordenadas de León, Guanajuato
        LatLng leon = new LatLng(21.1256, -101.6860);
        
        // Configurar la cámara para centrarse en León
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(leon)
                .zoom(13)
                .build();
        
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        
        // Habilitar controles de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
    }
}