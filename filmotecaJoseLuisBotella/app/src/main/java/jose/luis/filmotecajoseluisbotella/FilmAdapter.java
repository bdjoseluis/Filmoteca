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

    private Context context;
    private int resource;
    private ArrayList<Film> misPeliculas;

    public FilmAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Film> misPeliculas) {
        super(context, resource, misPeliculas);
        this.context = context;
        this.resource = resource;
        this.misPeliculas = misPeliculas;


    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflador = LayoutInflater.from(this.getContext());

        View mifila = inflador.inflate(resource, parent, false);

        Film film = misPeliculas.get(position);

        TextView titulo = mifila.findViewById(R.id.txtFilm);
        TextView director = mifila.findViewById(R.id.txtdirector);
        ImageView imgFilm = mifila.findViewById(R.id.imgFilm);

        titulo.setText(misPeliculas.get(position).getTitle());
        director.setText(misPeliculas.get(position).getDirector());
        imgFilm.setImageResource(misPeliculas.get(position).getImageResId());


        TextView titulodata = mifila.findViewById(R.id.titulodata);
        TextView directordata = mifila.findViewById(R.id.directordata);
        ImageView caratuladata = mifila.findViewById(R.id.caratuladata);

        //titulodata.setText(misPeliculas.get(position).getTitle());
        /*directordata.setText(misPeliculas.get(position).getDirector());
        caratuladata.setImageResource(misPeliculas.get(position).getImageResId());

        /*   String nombre=misPeliculas.get(position).getComments();
        txtCiudad.setText(nombre);
        String descripcion=misPeliculas.get(position).getDescripcion();
        txtDescripcion.setText(descripcion);
        int idimagen=misPeliculas.get(position).getImagen();
        imgCiudad.setImageResource(idimagen);


         */
        return mifila;
    }
        private String getGenreText(int genre) {
            return "Género: " + genre;
        }

    }
