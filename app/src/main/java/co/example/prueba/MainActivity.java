package co.example.prueba;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import co.example.prueba.modelo.Adaptador;
import co.example.prueba.modelo.item;
import co.example.prueba.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {


   ArrayList<item> lista;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


             lista= new ArrayList<>();
           recyclerView= findViewById(R.id.opcRecicler);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            llenarLista();

        Adaptador adaptador = new Adaptador(lista);

        recyclerView.setAdapter(adaptador);




    }

    private void llenarLista() {

        lista.add(new item("Equipo de oxigenoterapia","Equipos en Prestamo 6","https://semi.com.ve/wp-content/uploads/2018/12/2420EquipodeOxigenoS-30.jpg"));

        lista.add(new item("Torsos adulto para RCP","Equipos en Prestamo 6","https://www.cursosparamedicos.com.mx/productos/big/Prestan-Manikis-RCP-Torso-Adulto-Profesional-4-Pack--con-Monitor-LED-795606.jpg"));

        lista.add(new item("Desfibrilador EGC","Equipos en Prestamo 6","http://www.saludadomiciliomex.com/saludadomicilio/wp-content/uploads/2017/05/Desfibrilador-ECG-12.png"));

        lista.add(new item("Equipo de oxigenoterapia","Equipos en Prestamo 6","https://semi.com.ve/wp-content/uploads/2018/12/2420EquipodeOxigenoS-30.jpg"));

        lista.add(new item("Torsos adulto para RCP","Equipos en Prestamo 6","https://www.cursosparamedicos.com.mx/productos/big/Prestan-Manikis-RCP-Torso-Adulto-Profesional-4-Pack--con-Monitor-LED-795606.jpg"));

        lista.add(new item("Desfibrilador EGC","Equipos en Prestamo 6","http://www.saludadomiciliomex.com/saludadomicilio/wp-content/uploads/2017/05/Desfibrilador-ECG-12.png"));

        lista.add(new item("Equipo de oxigenoterapia","Equipos en Prestamo 6","https://semi.com.ve/wp-content/uploads/2018/12/2420EquipodeOxigenoS-30.jpg"));


    }
}