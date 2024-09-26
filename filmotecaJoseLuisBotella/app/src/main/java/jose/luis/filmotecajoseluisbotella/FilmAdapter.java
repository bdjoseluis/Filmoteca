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

import java.util.List;

public class FilmAdapter extends ArrayAdapter <Film>{

    private Context context;
    private int resource;
    private List<Film> misPeliculas;

    public FilmAdapter(@NonNull Context context, int resource, @NonNull List<Film> misPeliculas) {
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

        TextView titulo = mifila.findViewById(R.id.txtFilm);
        TextView director = mifila.findViewById(R.id.txtdirector);
        ImageView imgFilm = mifila.findViewById(R.id.imgFilm);

        titulo.setText(misPeliculas.get(position).getTitle());
        director.setText(misPeliculas.get(position).getDirector());
        imgFilm.setImageResource(misPeliculas.get(position).getImageResId());


        return mifila;
    }
}
