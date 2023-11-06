package jose.luis.filmotecajoseluisbotella;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FilmEditActivity extends AppCompatActivity {
    ImageView imagen;
    TextView titulo, Director, anyo, genre;



    private Film film;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_edit);

        Intent intent = getIntent();
        int posicion = intent.getIntExtra("FILM_POSITION", 0);

        film = FilmDataSource.films.get(posicion);
        imagen = findViewById(R.id.filmCoverImage);
        titulo = findViewById(R.id.editTitle);
        Director = findViewById(R.id.editDirector);
        anyo = findViewById(R.id.editYear);
        genre = findViewById(R.id.editGenre);
        Button captureImageButton = findViewById(R.id.captureImageButton);
        Button selectImageButton = findViewById(R.id.selectImageButton);
        Button saveButton = findViewById(R.id.saveButton);
        Button cancelButton = findViewById(R.id.cancelButton);


        imagen.setImageResource(film.getImageResId());
        titulo.setText(film.getTitle());
        Director.setText(film.getDirector());
        anyo.setText(String.valueOf(film.getYear()));
        genre.setText(Genero(film.getGenre()));



        // Implementa acciones para los botones aquí
        captureImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implementa la funcionalidad de capturar imagen
                Toast.makeText(FilmEditActivity.this, "Funcionalidad no implementada", Toast.LENGTH_SHORT).show();
            }
        });

        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implementa la funcionalidad de seleccionar imagen
                Toast.makeText(FilmEditActivity.this, "Funcionalidad no implementada", Toast.LENGTH_SHORT).show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implementa la funcionalidad para guardar los cambios

               // film.setTitle(String.valueOf(titulo));
                //film.setDirector(String.valueOf(Director));

                Toast.makeText(FilmEditActivity.this, "Cambios aplicados correctamente", Toast.LENGTH_SHORT).show();
                finish(); // Cierra la actividad actual
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implementa la funcionalidad para cancelar los cambios
                Toast.makeText(FilmEditActivity.this, "Los cambios han sido cancelados", Toast.LENGTH_SHORT).show();
                finish(); // Cierra la actividad actual
            }
        });

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

}