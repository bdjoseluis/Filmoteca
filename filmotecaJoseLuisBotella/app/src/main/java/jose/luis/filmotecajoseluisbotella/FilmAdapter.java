package jose.luis.filmotecajoseluisbotella;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends ArrayAdapter <Film>{

    private int mResource;
    private ArrayList<Film> misPeliculas;

    public FilmAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Film> objects) {
        super(context, resource, objects);

        mResource=resource;
        misPeliculas =objects;


    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflador=LayoutInflater.from(this.getContext());

        View mifila=inflador.inflate(mResource, parent, false);

        TextView txtCiudad= mifila.findViewById(R.id.txtFilm);
        TextView txtDescripcion=mifila.findViewById(R.id.txtDescripcion);
        ImageView imgCiudad=mifila.findViewById(R.id.imgFilm);

        String nombre=misPeliculas.get(position).getComments();
        txtCiudad.setText(nombre);
        String descripcion=misPeliculas.get(position).getDescripcion();
        txtDescripcion.setText(descripcion);
        int idimagen=misPeliculas.get(position).getImagen();
        imgCiudad.setImageResource(idimagen);

        return mifila;
    }
}