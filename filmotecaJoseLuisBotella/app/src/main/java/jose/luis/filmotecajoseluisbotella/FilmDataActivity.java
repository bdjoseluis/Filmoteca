package jose.luis.filmotecajoseluisbotella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmDataActivity extends AppCompatActivity {

    ArrayList<Film> films = FilmDataSource.films;
    int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_data);

        Intent intent = getIntent();
        posicion = intent.getIntExtra("FILM_POSITION", 0);

        Film film = films.get(posicion);

        ImageView caratula = findViewById(R.id.caratuladata);
        caratula.setImageResource(film.getImageResId());

        TextView titulo = findViewById(R.id.titulodata);
        titulo.setText(film.getTitle());

        TextView director = findViewById(R.id.directordata);
        director.setText(film.getDirector());

        TextView anyo = findViewById(R.id.anyodata);
        anyo.setText(String.valueOf(film.getYear()));

        TextView genero = findViewById(R.id.genero);
        genero.setText(Genero(film.getGenre()));

        TextView formato = findViewById(R.id.tipodataa);
        formato.setText(formato(film.getFormat()));


    Button imdbButton = findViewById(R.id.enlaceweb);
        imdbButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String imdbUrl = film.getImdbUrl();
            Uri uri = Uri.parse(imdbUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    });

    Button volverButton = findViewById(R.id.volverdata);
        volverButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });

    Button editarButton = findViewById(R.id.editardata);
        editarButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(FilmDataActivity.this, FilmEditActivity.class);
            intent.putExtra("FILM_POSITION", posicion);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    });}

        private String Genero(int genre) {
            switch (genre) {
                case Film.GENRE_ACTION:
                    return "Acción";
                case Film.GENRE_COMEDY:
                    return "Comedia";
                case Film.GENRE_DRAMA:
                    return "Drama";
                case Film.GENRE_SCIFI:
                    return "Ciencia Ficción";
                case Film.GENRE_HORROR:
                    return "Terror";
                default:
                    return "Desconocido";
            }
        }

        private String formato(int format) {
            switch (format) {
                case Film.FORMAT_DVD:
                    return "DVD";
                case Film.FORMAT_BLURAY:
                    return "Blu-ray";
                case Film.FORMAT_DIGITAL:
                    return "Digital";
                default:
                    return "Desconocido";
            }
        }
}