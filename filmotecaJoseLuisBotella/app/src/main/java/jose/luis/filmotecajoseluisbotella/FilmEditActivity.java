package jose.luis.filmotecajoseluisbotella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmEditActivity extends AppCompatActivity {
    ImageView imagen;
    private static final int PermisoCamara = 5;
    TextView titulo, Director, anyo, comentarios, url;
    Spinner genre, formato;
    int posicion=0;
    private SQLiteDatabase db;


    private static final int codigoPelicula = 1;
    Button captureImageButton;
    Button selectImageButton;
    Film film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_edit);

        // Inicializa la base de datos
        db = openOrCreateDatabase("MisPeliculas", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS peliculas(Imagen INTEGER, Titulo VARCHAR, Director VARCHAR, Año INTEGER, Genero INTEGER, Formato INTEGER, URL VARCHAR, Comentarios VARCHAR);");

        Intent intent = getIntent();
        posicion = intent.getIntExtra("FILM_POSITION", 0);

        film = listar();

        captureImageButton = findViewById(R.id.captureImageButton);
        selectImageButton = findViewById(R.id.selectImageButton);

        crearDatos(obtenerPeliculaDesdeBaseDeDatos());
        Button saveButton = findViewById(R.id.saveButton);
        Button cancelButton = findViewById(R.id.cancelButton);
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("FILM_POSITION")) {
            // Limpia la notificación si la actividad fue iniciada desde una notificación
            clearNotification();
        }


        // Implementa acciones para los botones aquí
        captureImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int estado = ContextCompat.checkSelfPermission(FilmEditActivity.this, android.Manifest.permission.CAMERA);

                if (estado == PackageManager.PERMISSION_GRANTED) {
                    Intent in = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivityForResult(in, codigoPelicula);
                } else {
                    mostrartoastpropio("No tienes permiso");
                }
            }
        });

        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implementa la funcionalidad de seleccionar imagen de la galería
                verificarPermisosCamara();
                mostrartoastpropio("Funcionalidad de galería no implementada");
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            String añoStr = anyo.getText().toString();
            int año = Integer.parseInt(añoStr);


            @Override
            public void onClick(View view) {
                //String updateQuery = "UPDATE peliculas SET Titulo = '" + ((TextView) findViewById(R.id.nuevoTitulo)).getText().toString() + "', Director = '" + ((TextView) findViewById(R.id.nuevoDirector)).getText().toString() + "', Año = '" + Integer.parseInt(añoStr) + "', Genero = '" + gen + "', Formato = '" + form + "', URL = '" + ((TextView) findViewById(R.id.nuevaURL)).getText().toString() + "', Comentarios = '" + ((TextView) findViewById(R.id.nuevaDescripcion)).getText().toString() + "' WHERE id = '" + position + "';";

                String updateQuery = "UPDATE peliculas SET " +
                        "Imagen = " + film.getImageResId() + ", " +
                        "Titulo = '" + ((TextView) findViewById(R.id.editTitle)).getText().toString() + "', " +
                        "Director = '" + ((TextView) findViewById(R.id.editDirector)).getText().toString() + "', " +
                        "Año = " + Integer.parseInt(añoStr) + ", " +
                        "Formato = " + formato.getSelectedItemPosition() + ", " +
                        "Genero = " + genre.getSelectedItemPosition() + ", " +
                        "URL = '" + ((TextView) findViewById(R.id.urledi)).getText().toString() + "', " +
                        "Comentarios = '" + ((TextView) findViewById(R.id.editcomenta)).getText().toString() + "' " +
                        "WHERE id = " + film.getId();

                try (SQLiteDatabase db = openOrCreateDatabase("MisPeliculas", MODE_PRIVATE, null)) {
                    db.execSQL(updateQuery);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mostrartoastpropio("Película actualizada");

                setResult(RESULT_OK, null);
                finish();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrartoastpropio("Los cambios han sido cancelados");
                finish(); // Cierra la actividad actual
            }
        });
    }

    private void clearNotification() {
        ((NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE)).cancel(1);
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

            imagen = findViewById(R.id.filmCoverImage);
            titulo = findViewById(R.id.editTitle);
            Director = findViewById(R.id.editDirector);
            comentarios = findViewById(R.id.editcomenta);
            anyo = findViewById(R.id.editYear);
            genre = findViewById(R.id.editGenero);
            url = findViewById(R.id.urledi);
            formato = findViewById(R.id.editformato);

            imagen.setImageResource(film.getImageResId());
            titulo.setText(film.getTitle());
            Director.setText(film.getDirector());
            anyo.setText(String.valueOf(film.getYear()));
            comentarios.setText(film.getComments());
            url.setText(film.getImdbUrl());
            genre.setSelection(film.getGenre());
            formato.setSelection(film.getFormat());
            setupSpinnerGenero();
            setupSpinnerFormato();
        }
    }

    private void setupSpinnerGenero() {
        Spinner spinner = findViewById(R.id.editGenero);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genero, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setupSpinnerFormato() {
        Spinner spinner = findViewById(R.id.editformato);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.formato, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void verificarPermisosCamara() {
        int estado = ContextCompat.checkSelfPermission(FilmEditActivity.this, Manifest.permission.CAMERA);
        if (estado == PackageManager.PERMISSION_GRANTED) {
            mostrartoastpropio("El permiso para la cámara ya está concedido");
        } else {
            ActivityCompat.requestPermissions(FilmEditActivity.this, new String[]{Manifest.permission.CAMERA}, PermisoCamara);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PermisoCamara:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mostrartoastpropio("Permiso concedido para la cámara");
                    captureImageButton.setVisibility(View.VISIBLE);
                    selectImageButton.setVisibility(View.GONE);
                } else {
                    mostrartoastpropio("Permiso denegado para la cámara");
                    selectImageButton.setVisibility(View.VISIBLE);
                    captureImageButton.setVisibility(View.GONE);
                }
        }
    }


    private void saveImageToInternalStorage(Bitmap bitmapImage) {
        ContextWrapper wrapper = new ContextWrapper(getApplicationContext());

        // Directorio donde se almacenará la imagen
        File directory = wrapper.getDir("images", Context.MODE_PRIVATE);

        // Nombre del archivo de imagen
        String fileName = "myImage.jpg";

        // Archivo donde se guardará la imagen
        File file = new File(directory, fileName);

        try {
            // Stream para escribir el Bitmap en el archivo
            FileOutputStream fos = new FileOutputStream(file);
            bitmapImage.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Film listar() {

        List<Film> lista = new ArrayList<>();

        // Leer de la base de datos y añadir a la lista
        Cursor cursor = db.rawQuery("SELECT * FROM peliculas", null);
        if(cursor.getCount() == 0){
            mostrartoastpropio("No tienes elementos en la base de datos");
        }
        else{
            while(cursor.moveToNext()){
                lista.add(new Film(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            }
        }
        cursor.close();

        return lista.get(posicion);
    }

    private void mostrartoastpropio(String texto) {
        Toast mensaje = new Toast(FilmEditActivity.this);
        View mensaje_layaout = getLayoutInflater().inflate(R.layout.toast_propio, null);
        mensaje.setView(mensaje_layaout);
        TextView textoToast = (TextView) mensaje_layaout.findViewById(R.id.toastMessage);
        textoToast.setText(texto);
        mensaje.setDuration(Toast.LENGTH_SHORT);
        mensaje.show();
    }

}
