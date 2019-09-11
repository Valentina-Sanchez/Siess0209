package co.example.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    Button boton;
    EditText usuario, con;


    String nombreAd = "Admin" , nomUs = "User";
    String conn = "admin", conn2= "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        inicializarViews();

        getSupportActionBar().hide();

    }

    public void inicializarViews() {
        usuario = (EditText) findViewById(R.id.nom);
        con = (EditText) findViewById(R.id.pas);
        boton = (Button) findViewById(R.id.btnAcep);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (usuario.getText().toString().equals(nombreAd) && con.getText().toString().equals(conn)) {
                    Toast.makeText(Inicio.this, "Bienvenido" + nombreAd, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Inicio.this, Contenedor.class);
                    startActivity(intent);
                } else if (usuario.getText().toString().equals(nomUs) && con.getText().toString().equals(conn2)) {
                    Toast.makeText(Inicio.this, "Bienvenido" + nomUs, Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(Inicio.this, Prestamos.class);
                    startActivity(in);
                } else {
                    Toast.makeText(Inicio.this, "Verifique sus datos", Toast.LENGTH_SHORT).show();

                }
            }
        });

        NotificationCompat.Builder builder = new NotificationCompat.Builder(Inicio.this, Notification.EXTRA_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Titulo")
                .setContentText("Contenido")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

    }
}