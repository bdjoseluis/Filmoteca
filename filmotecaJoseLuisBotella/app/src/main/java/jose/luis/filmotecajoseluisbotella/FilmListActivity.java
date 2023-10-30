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

    ArrayList<String> peliculas =new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filmlistactivity);

        FilmDataSource.Initialize();
        ListView lista = (ListView) findViewById(R.id.listapeliculas);
        FilmAdapter miadaptador = new FilmAdapter(this, R.layout.item_film, FilmDataSource.films);
        lista.setAdapter(miadaptador);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        //Toast.makeText(MainActivity.this, "Se ha pulsado sobre"+ ciudades.get(i) , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(FilmListActivity.this, FilmDataSource.class);
        intent.putExtra("FILM_POSITION", l);
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


        switch (id){
            case R.id.itemConfFacturas:
                Toast.makeText(getApplicationContext(), "Has Pulsado configuracion de facturas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemConfPedidos:
                Toast.makeText(getApplicationContext(), "Has Pulsado configuracion de pedidos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemconfclientes:
                Toast.makeText(getApplicationContext(), "Has Pulsado configuracion de clientes", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemAcercaDe:
                Toast.makeText(getApplicationContext(), "Has Pulsado acerca", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
