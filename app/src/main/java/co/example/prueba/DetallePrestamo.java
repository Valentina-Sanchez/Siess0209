package co.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DetallePrestamo extends AppCompatActivity {

    ImageView imageView;
    TextView codigo, fechaSolicitud, fechaSalida ,fechaDevolucion, estado, ficha, municipio, responsable , obser;
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
        obser=findViewById(R.id.ob);

        codigo.setText(Prestamos.prestamos.get(0).getCodigo().toString());
        fechaSolicitud.setText((int) Prestamos.prestamos.get(0).getFechasolicitud());
        fechaSalida.setText(Prestamos.prestamos.get(0).getFechasalida().toString());
        fechaDevolucion.setText(Prestamos.prestamos.get(0).getFechadevolucion().toString());
        estado.setText(Prestamos.prestamos.get(0).getEstado());
        obser.setText(Prestamos.prestamos.get(0).getObservacion());
        ficha.setText(Prestamos.prestamos.get(0).getFk_ficha().getCodigo());
        municipio.setText(Prestamos.prestamos.get(0).getFk_municipio().toString());
        responsable.setText(Prestamos.prestamos.get(0).getFk_responsable().toString());

        Bundle datos = this.getIntent().getExtras();
        String codigo= datos.getString("codigo","0");
        String fechaSol = datos.getString("fechaSol", "0" );
        String fechaSal = datos.getString("fechaSal","0");
        String fechaDe = datos.getString("fechaDe","0");
        String estado = datos.getString("estado","0");
        String obser = datos.getString("observacion", "0");
        String ficha = datos.getString("ficha","0");
        String municipio = datos.getString("municipio","0");
        String responsable = datos.getString("responsable","0");

    }
}
