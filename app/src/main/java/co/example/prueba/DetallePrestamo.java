package co.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DetallePrestamo extends AppCompatActivity {

    ImageView imageView;
    TextView codigo, fechaSolicitud, fechaSalida ,fechaDevolucion, estado, ficha, municipio, responsable;
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_prestamo);

        codigo = findViewById(R.id.cod);
        fechaSolicitud = findViewById(R.id.feSol);
        fechaSalida = findViewById(R.id.feSal);
        fechaDevolucion = findViewById(R.id.feDe);
        estado = findViewById(R.id.ESTADO);
        ficha= findViewById(R.id.ficha);
        municipio=findViewById(R.id.muni);
        responsable=findViewById(R.id.resp);

        codigo.setText(Prestamos.prestamos.get(0).getCodigo().toString());
        fechaSolicitud.setText(Prestamos.prestamos.get(1).getFechasolicitud().toString());
        fechaSalida.setText(Prestamos.prestamos.get(2).getFechasalida().toString());
        fechaDevolucion.setText(Prestamos.prestamos.get(3).getFechadevolucion().toString());
        estado.setText(Prestamos.prestamos.get(4).getEstado());
        ficha.setText(Prestamos.prestamos.get(5).getFk_ficha().toString());
        municipio.setText(Prestamos.prestamos.get(6).getFk_municipio().toString());
        responsable.setText(Prestamos.prestamos.get(7).getFk_responsable().toString());

        Bundle datos = this.getIntent().getExtras();
        String codigo= datos.getString("codigo");
        String fechaSol = datos.getString("fechaSol");
        String fechaSal = datos.getString("fechaSal");
        String fechaDe = datos.getString("fechaDe");
        String estado = datos.getString("estado");
        String ficha = datos.getString("ficha");
        String municipio = datos.getString("municipio");
        String responsable = datos.getString("responsable");

    }
}
