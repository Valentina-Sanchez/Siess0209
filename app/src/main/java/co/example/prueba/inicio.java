package co.example.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class inicio extends AppCompatActivity {

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
                    Toast.makeText(inicio.this, "Bienvenido" + nombreAd, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(inicio.this, contenedor.class);
                    startActivity(intent);
                } else if (usuario.getText().toString().equals(nomUs) && con.getText().toString().equals(conn2)) {
                    Toast.makeText(inicio.this, "Bienvenido" + nomUs, Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(inicio.this, prestamos.class);
                    startActivity(in);
                } else {
                    Toast.makeText(inicio.this, "Verifique sus datos", Toast.LENGTH_SHORT).show();

                }
            }
        });

        NotificationCompat.Builder builder = new NotificationCompat.Builder(inicio.this, Notification.EXTRA_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Titulo")
                .setContentText("Contenido")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

    }
}