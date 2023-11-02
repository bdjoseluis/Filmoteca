package jose.luis.filmotecajoseluisbotella;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FilmEditActivity extends AppCompatActivity {
    private ImageView filmCoverImage;
    private TextView editTitle, editDirector, editYear, editGenre;
    private Button captureImageButton, selectImageButton, saveButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_edit);
        filmCoverImage = findViewById(R.id.filmCoverImage);
        editTitle = findViewById(R.id.editTitle);
        editDirector = findViewById(R.id.editDirector);
        editYear = findViewById(R.id.editYear);
        editGenre = findViewById(R.id.editGenre);
        captureImageButton = findViewById(R.id.captureImageButton);
        selectImageButton = findViewById(R.id.selectImageButton);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);

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
}