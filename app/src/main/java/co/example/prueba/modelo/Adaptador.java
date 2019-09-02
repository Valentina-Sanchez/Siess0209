package co.example.prueba.modelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.example.prueba.R;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderItem> {

    ArrayList<item> lista;

    public Adaptador(ArrayList<item> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemopc,null,false);

        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItem holder, int position) {

        item itemModel = lista.get(position);
        Picasso.get().load(itemModel.getFoto()).into(ViewHolderItem.imagen1);
        holder.nombre.setText(lista.get(position).getNombre());
        holder.desc.setText(lista.get(position).getDescripcion());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder {

        public static ImageView imagen1;
        TextView nombre, desc;

        public ViewHolderItem(@NonNull View itemView) {
         super(itemView);

         nombre= itemView.findViewById(R.id.nombre);
         desc=itemView.findViewById(R.id.desc);
         imagen1=itemView.findViewById(R.id.imagen);


        }

    }
}
