package co.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.example.prueba.consumo.Prestamo;
import co.example.prueba.consumo.PostServicePrestamos;
import co.example.prueba.modelo.Ficha;
import co.example.prueba.modelo.Municipio;
import co.example.prueba.modelo.Responsable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Prestamos extends AppCompatActivity {

    ListView list;
    ArrayList <String> titles = new ArrayList<>();
    public static ArrayList<Prestamo> prestamos = new ArrayList<>();
    ArrayList<Ficha> fichas = new ArrayList<>();
    ArrayList<Municipio> municipios = new ArrayList<>();
    ArrayList<Responsable> responsables = new ArrayList<>();
    ArrayAdapter arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos);

        arrayAdapter = new ArrayAdapter(Prestamos.this,android.R.layout.simple_list_item_1,titles);
        list = findViewById(R.id.listaPrestamo);

        list.setAdapter(arrayAdapter);


        getPosts();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Prestamos.this, DetallePrestamo.class);
                intent.putExtra("codigo", prestamos.get(0).getCodigo());
                intent.putExtra("fechaSol", prestamos.get(0).getFechasolicitud());
                intent.putExtra("fechaSal", prestamos.get(0).getFechasalida());
                intent.putExtra("fechaDe", prestamos.get(0).getFechadevolucion());
                intent.putExtra("estado", prestamos.get(0).getEstado());
                intent.putExtra("observacion", prestamos.get(0).getObservacion());
                intent.putExtra("ficha",prestamos.get(0).getFk_ficha().getCodigo());
                intent.putExtra("municipio", prestamos.get(0).getFk_municipio()+"");
                intent.putExtra("responsable", prestamos.get(0).getFk_responsable()+"");
                startActivity(intent);
            }
        });

    }

    private void getPosts () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.75.199.41:8085/siessPro-1.0.0/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        PostServicePrestamos postService = retrofit.create(PostServicePrestamos.class);

        Call<List<Prestamo>> call = postService.getPost();

        call.enqueue(new Callback<List<Prestamo>>() {
            @Override
            public void onResponse(Call<List<Prestamo>> call, Response<List<Prestamo>> response) {
                for (Prestamo prestamo : response.body()) {
                    titles.add(prestamo.getFechadevolucion());
                    fichas.add(prestamo.getFk_ficha());
                    municipios.add(prestamo.getFk_municipio());
                    responsables.add(prestamo.getFk_responsable());
                    prestamos.add(prestamo);

                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Prestamo>> call, Throwable t) {
                Log.d("ERROR", t+" ");
            }
        });
    }

}
