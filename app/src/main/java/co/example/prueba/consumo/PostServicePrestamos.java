package co.example.prueba.consumo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServicePrestamos {

        String API_ROUTE = "webresources/siess1.jpa.entidades.prestamo";

        @GET(API_ROUTE)
        Call<List<Prestamo>> getPost();

    }

