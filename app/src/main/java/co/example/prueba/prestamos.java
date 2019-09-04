package co.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import co.example.prueba.consumo.Prestamo;
import co.example.prueba.consumo.PostServicePrestamos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class prestamos extends AppCompatActivity {

    ListView list;
    ArrayList <String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos);

        arrayAdapter = new ArrayAdapter(prestamos.this,android.R.layout.simple_list_item_1,titles);
        list = findViewById(R.id.listaPrestamo);

        list.setAdapter(arrayAdapter);


        getPosts();

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
                    titles.add(""+prestamo.getFechadevolucion());
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
