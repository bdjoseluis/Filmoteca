package jose.luis.filmotecajoseluisbotella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FilmListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ArrayList<Film> films;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filmlistactivity);

        FilmDataSource.Initialize();
        films = FilmDataSource.films;
        ArrayList<Film> films = FilmDataSource.films;
        ListView lista = (ListView) findViewById(R.id.listapeliculas);
        FilmAdapter miadaptador = new FilmAdapter(this, R.layout.item_film, FilmDataSource.films);
        lista.setAdapter(miadaptador);
        lista.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        //Toast.makeText(MainActivity.this, "Se ha pulsado sobre"+ ciudades.get(i) , Toast.LENGTH_SHORT).show();
        //Film selectedFilm = films.get(i);

        Intent intent = new Intent(this, FilmDataActivity.class);
        intent.putExtra("FILM_POSITION", i);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itemAgregarPelicula:
                Intent agregar = new Intent(FilmListActivity.this, AgregarActivity.class);
                startActivity(agregar);
                return true;
            case R.id.itemAcercaDe:
                // Abre la actividad AboutActivity
                Intent aboutIntent = new Intent(FilmListActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
