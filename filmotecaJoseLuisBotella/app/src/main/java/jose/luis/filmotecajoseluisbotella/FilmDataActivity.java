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
    private Film film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_data);

        Intent intent =  new Intent(FilmDataActivity.this, FilmDataActivity.class);
        posicion = intent.getIntExtra("FILM_POSITION", 0);//mirarselo preguntar a german por q me tiene hartico
       // Intent intent = new Intent(FilmDataListActivity.this, FilmDataActivity.class);

        //Film film = films.get(posicion);
        film = FilmDataSource.films.get(posicion);

        if (film != null) {

            setTitle(film.getTitle());

            ImageView caratulaImageView = findViewById(R.id.caratuladata);
            TextView tituloTextView = findViewById(R.id.titulodata);
            TextView directorTextView = findViewById(R.id.directordata);
            TextView anyoTextView = findViewById(R.id.anyodata);
            TextView formatoTextView = findViewById(R.id.tipodataa);
            TextView generoTextView = findViewById(R.id.genero);
            TextView descripcionTextView = findViewById(R.id.descripciondata);

            caratulaImageView.setImageResource(film.getImageResId());
            tituloTextView.setText(film.getTitle());
            directorTextView.setText(film.getDirector());
            anyoTextView.setText(String.valueOf(film.getYear()));
            formatoTextView.setText(formato(film.getFormat()));
            generoTextView.setText(Genero(film.getGenre()));
            descripcionTextView.setText(film.getComments());
        }


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
                    return "Drama, ";
                case Film.GENRE_SCIFI:
                    return "Scifi";
                case Film.GENRE_HORROR:
                    return "Terror";
                default:
                    return "Desconocido";
            }
        }

        private String formato(int format) {
            switch (format) {
                case Film.FORMAT_DVD:
                    return "DVD, ";
                case Film.FORMAT_BLURAY:
                    return "Blu-ray, ";
                case Film.FORMAT_DIGITAL:
                    return "Digital, ";
                default:
                    return "Desconocido";
            }
}

}