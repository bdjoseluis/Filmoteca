package jose.luis.filmotecajoseluisbotella;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FilmDataActivity extends AppCompatActivity {
    private Film film;
    private static final int codigoPelicula = 1;
    int posicion;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_data);

        // Inicializa la base de datos
        db = openOrCreateDatabase("MisPeliculas", MODE_PRIVATE, null);

        Intent intent = getIntent();
        posicion = intent.getIntExtra("FILM_POSITION", 0);


        obtenerPeliculaDesdeBaseDeDatos();
        crearDatos(obtenerPeliculaDesdeBaseDeDatos());
    }

    private Film obtenerPeliculaDesdeBaseDeDatos() {
        List<Film> listado = new ArrayList<Film>();
        // Codigo para leer de la base de datos y añadir a la lista.
        Cursor c = db.rawQuery("SELECT * FROM peliculas", null);
            while(c.moveToNext()){
                int id = c.getInt(0);
                int imagen = c.getInt(1);
                String titulo = c.getString(2);
                String director = c.getString(3);
                int año = c.getInt(4);
                int formato = c.getInt(5);
                int genero = c.getInt(6);
                String url = c.getString(7);
                String comentarios = c.getString(8);

                listado.add(new Film(id, imagen, titulo, director, año, formato, genero, url, comentarios));
        }
        c.close();
        return listado.get(posicion);
    }

    private void crearDatos(Film film) {
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

            Button imdbButton = findViewById(R.id.enlaceweb);
            imdbButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String imdbUrl = film.getImdbUrl();
                    Uri uri = Uri.parse(imdbUrl);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
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
                    startActivityForResult(intent, codigoPelicula);
                }
            });
        }
    }

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case codigoPelicula:
                if (resultCode == Activity.RESULT_OK) {
                    crearDatos(obtenerPeliculaDesdeBaseDeDatos());
                    setResult(RESULT_OK, null);
                }
                if (resultCode == Activity.RESULT_CANCELED) {
                    mostrartoastpropio("No se ha hecho el cambio");
                }
        }
    }

    private void mostrartoastpropio(String texto) {
        Toast mensaje = new Toast(FilmDataActivity.this);
        View mensaje_layaout = getLayoutInflater().inflate(R.layout.toast_propio, null);
        mensaje.setView(mensaje_layaout);
        TextView textoToast = (TextView) mensaje_layaout.findViewById(R.id.toastMessage);
        textoToast.setText(texto);
        mensaje.setDuration(Toast.LENGTH_SHORT);
        mensaje.show();
    }
}